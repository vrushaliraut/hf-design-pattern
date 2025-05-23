package com.vrushali.lld.tbs.service;

import com.vrushali.lld.tbs.Exception.SeatAlreadyBookedException;
import com.vrushali.lld.tbs.Exception.ShowTimeNotFoundException;
import com.vrushali.lld.tbs.model.*;
import com.vrushali.lld.tbs.repository.BookingRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import com.vrushali.lld.tbs.repository.ShowTimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    private BookingService bookingService;
    private BookingRepository bookingRepository;
    private ShowTimeRepository showTimeRepository;

    private SeatInventoryRepository seatInventoryRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = new BookingRepository();
        showTimeRepository = new ShowTimeRepository();
        seatInventoryRepository = new SeatInventoryRepository();

        bookingService = new BookingService(bookingRepository, seatInventoryRepository, showTimeRepository);

        // Preload showtime
        ShowTime showTime = new ShowTime("ST001", "E001", "V001", LocalDateTime.now(),
                LocalDateTime.now().plusHours(2));

        showTimeRepository.save(showTime);

        // Preload seats
        Map<String, Seat> seats = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150)
        );

        seatInventoryRepository.save(new SeatInventory("ST001", seats));
    }

    @Test
    void shouldBookAvailableSeatsSuccessfully() {
        Booking booking = bookingService.bookSeats("U001", "ST001", List.of("A1", "A2"));

        assertThat(booking).isNotNull();
        assertThat(booking.getSeatIds()).containsExactlyInAnyOrder("A1", "A2");

        SeatInventory updatedInventory = seatInventoryRepository.findByShowTimeId("ST001").get();
        assertThat(updatedInventory.getSeatStatus("A1")).isEqualTo(SeatStatus.BOOKED);
    }

    @Test
    void shouldThrowExceptionWhenBookingAlreadyBookedSeat() {
        bookingService.bookSeats("U001", "ST001", List.of("A1"));

        assertThatThrownBy(() -> bookingService.bookSeats("U001", "ST001", List.of("A1")))
                .isInstanceOf(SeatAlreadyBookedException.class)
                .hasMessageContaining("A1");
    }

    @Test
    void shouldThrowExceptionWhenShowTimeDoesNotExist() {
        assertThatThrownBy(() -> bookingService.bookSeats("U003", "INVALID", List.of("A1")))
                .isInstanceOf(ShowTimeNotFoundException.class)
                .hasMessageContaining("ShowTime not found");
    }

    @Test
    void shouldAllowOnlyOneBookingForSameSeatConcurrently() throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Booking> task1 = () -> bookingService.bookSeats("U001", "ST001", List.of("A1"));
        Callable<Booking> task2 = () -> bookingService.bookSeats("U002", "ST001", List.of("A1"));

        Future<Booking> futureBooking1 = executor.submit(task1);
        Future<Booking> futureBooking2 = executor.submit(task2);
        List<Future<Booking>> futureList = List.of(futureBooking1, futureBooking2);

        int successCount = 0;
        int failureCount = 0;

        for(Future<Booking> bookingFuture : futureList){
            try {
                Booking booking = bookingFuture.get();
                assertThat(booking).isNotNull();
                successCount++;
            }catch (ExecutionException ex){
                Throwable cause = ex.getCause();
                assertThat(cause).isInstanceOf(SeatAlreadyBookedException.class);
                failureCount++;
            }
        }

        executor.shutdown();

        //If you run this test now, both bookings may succeed because our SeatInventory and BookingService are not synchronized.

        assertThat(successCount).isEqualTo(1);
        assertThat(failureCount).isEqualTo(1);
    }

}