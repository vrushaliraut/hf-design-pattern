package com.vrushali.lld.car.rental.system.model.valueobject;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BookingIntervalTest {
    @Test
    void shouldCreateBookingIntervalWithValidTimestamps() {
        LocalDateTime start = LocalDateTime.of(2025, 5, 9, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025, 5, 9, 14, 0);

        BookingInterval interval = new BookingInterval(start, end);

        assertThat(interval.getStart()).isEqualTo(start);
        assertThat(interval.getEnd()).isEqualTo(end);
    }

    @Test
    void shouldThrowExceptionWhenStartIsAfterEnd(){
        LocalDateTime start = LocalDateTime.of(2025, 5,9,14,0);
        LocalDateTime end = LocalDateTime.of(2025, 5,9,10,0);

        assertThatThrownBy(() -> new BookingInterval(start,end))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Start time must be before end time");
    }


    @Test
    void shouldThrowExceptionWhenStartOrEndIsNull(){
        LocalDateTime validTime = LocalDateTime.of(2025, 5, 9, 10, 0);
        assertThatThrownBy(() -> new BookingInterval(null,validTime))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be null");

        assertThatThrownBy(() -> new BookingInterval(validTime, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be null");
    }

    @Test
    void shouldDetectOverlappingIntervals() {
        BookingInterval i1 = new BookingInterval(
                LocalDateTime.of(2025, 5, 9, 10, 0),
                LocalDateTime.of(2025, 5, 9, 14, 0)
        );

        BookingInterval i2 = new BookingInterval(
                LocalDateTime.of(2025, 5, 9, 13, 0),
                LocalDateTime.of(2025, 5, 9, 16, 0)
        );

        BookingInterval i3 = new BookingInterval(
                LocalDateTime.of(2025, 5, 9, 14, 0),
                LocalDateTime.of(2025, 5, 9, 17, 0)
        );

        assertThat(i1.overlapsWith(i2)).isTrue();
        assertThat(i1.overlapsWith(i3)).isFalse();
    }


}