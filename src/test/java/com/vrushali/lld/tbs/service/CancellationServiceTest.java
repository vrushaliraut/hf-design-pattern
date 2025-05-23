package com.vrushali.lld.tbs.service;

import com.vrushali.lld.tbs.Exception.BookingNotFoundException;
import com.vrushali.lld.tbs.model.*;
import com.vrushali.lld.tbs.repository.BookingRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CancellationServiceTest {
    private CancellationService cancellationService;
    private BookingRepository bookingRepository;
    private SeatInventoryRepository seatInventoryRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = new BookingRepository();
        seatInventoryRepository = new SeatInventoryRepository();
        cancellationService = new CancellationService(bookingRepository, seatInventoryRepository);

        // Prepopulate booking and inventory
        Map<String, Seat> seats = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150)
        );

        SeatInventory inventory = new SeatInventory("ST001", seats);
        inventory.setSeatStatus("A1", SeatStatus.BOOKED);
        inventory.setSeatStatus("A2", SeatStatus.BOOKED);
        seatInventoryRepository.save(inventory);

        Booking booking = new Booking("B001", "U001", "ST001", List.of("A1", "A2"));
        bookingRepository.save(booking);
    }

    @Test
    void shouldCancelBookingAndFreeSeats(){
        cancellationService.cancelBooking("B001");

        Booking booking = bookingRepository.findByBookingId("B001").get();

        SeatInventory updatedInventory = seatInventoryRepository.findByShowTimeId("ST001").get();

        assertThat(booking.getStatus()).isEqualTo(BookingStatus.CANCELLED);
        assertThat(updatedInventory.getSeatStatus("A1")).isEqualTo(SeatStatus.AVAILABLE);
        assertThat(updatedInventory.getSeatStatus("A2")).isEqualTo(SeatStatus.AVAILABLE);
    }

    @Test
    void shouldThrowExceptionWhenBookingDoesNotExist(){
        assertThatThrownBy(() -> cancellationService.cancelBooking("INVALID_ID"))
                .isInstanceOf(BookingNotFoundException.class)
                .hasMessageContaining("Booking not found");
    }
}