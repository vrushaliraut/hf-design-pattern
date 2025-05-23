package com.vrushali.lld.tbs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking(
                "B001",
                "U001",
                "ST001",
                List.of("A1", "A2")
        );
    }

    @Test
    void shouldCreateBookingWithCorrectFields(){
        assertThat(booking.getId()).isEqualTo("B001");
        assertThat(booking.getUserId()).isEqualTo("U001");
        assertThat(booking.getShowTimeId()).isEqualTo("ST001");
        assertThat(booking.getSeatIds()).containsExactly("A1", "A2");
    }

    @Test
    void shouldSetStatusToBookedOnCreation(){
        assertThat(booking.getStatus()).isEqualTo(BookingStatus.BOOKED);
    }

    @Test
    void shouldUpdateStatusToCancelledWhenCancelled() {
        booking.cancel();
        assertThat(booking.getStatus()).isEqualTo(BookingStatus.CANCELLED);
    }

    @Test
    void shouldAssignTimestampOnCreation() {
        assertThat(booking.getTimestamp()).isBeforeOrEqualTo(LocalDateTime.now());
    }
}