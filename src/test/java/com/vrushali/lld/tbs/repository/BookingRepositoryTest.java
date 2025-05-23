package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    private BookingRepository bookingRepository;

    @BeforeEach
    void setUp() {
        bookingRepository = new BookingRepository();
    }

    @Test
    void shouldSaveAndRetrieveBooking() {
        Booking booking = new Booking("B001", "U001", "ST001",
                List.of("A1", "A2"));
        bookingRepository.save(booking);

        assertThat(bookingRepository.findByBookingId("B001")).isPresent().contains(booking);
    }

    @Test
    void shouldReturnAllBookingsByUserId() {
        Booking b1 = new Booking("B001", "U001", "ST001", List.of("A1"));
        Booking b2 = new Booking("B002", "U001", "ST002", List.of("A2"));
        Booking b3 = new Booking("B003", "U002", "ST001", List.of("B1"));

        bookingRepository.save(b1);
        bookingRepository.save(b2);
        bookingRepository.save(b3);

        List<Booking> userBookings = bookingRepository.findByUserId("U001");

        assertThat(userBookings).hasSize(2).containsExactlyInAnyOrder(b1, b2);
    }

    @Test
    void shouldReturnAllBookingsByShowTimeId() {
        Booking b1 = new Booking("B001", "U001", "ST001", List.of("A1"));
        Booking b2 = new Booking("B002", "U002", "ST001", List.of("A2"));
        Booking b3 = new Booking("B003", "U002", "ST002", List.of("B1"));

        bookingRepository.save(b1);
        bookingRepository.save(b2);
        bookingRepository.save(b3);

        List<Booking> showBookings = bookingRepository.findByShowTimeId("ST001");

        assertThat(showBookings).hasSize(2).containsExactlyInAnyOrder(b1, b2);
    }

    @Test
    void shouldDeleteBookingById() {
        Booking booking = new Booking("B001", "U001", "ST001", List.of("A1"));
        bookingRepository.save(booking);

        bookingRepository.deleteById("B001");

        assertThat(bookingRepository.findByBookingId("B001")).isEmpty();
    }
}