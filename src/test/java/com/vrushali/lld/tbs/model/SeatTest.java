package com.vrushali.lld.tbs.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatTest {
    @Test
    void shouldCreateSeatWithCorrectValues(){
        Seat seat = new Seat("A1", SeatCategory.PREMIUM, 150);

        assertThat(seat.getId()).isEqualTo("A1");
        assertThat(seat.getCategory()).isEqualTo(SeatCategory.PREMIUM);
        assertThat(seat.getPrice()).isEqualTo(150);
    }

    @Test
    void seatsWithSameIdShouldBeEqual() {
        Seat seat1 = new Seat("A1", SeatCategory.REGULAR, 100);
        Seat seat2 = new Seat("A1", SeatCategory.REGULAR, 100);
        assertThat(seat1).isEqualTo(seat2);
        assertThat(seat1.hashCode()).isEqualTo(seat2.hashCode());

    }

    @Test
    void seatsWithDifferentIdsShouldNotBeEqual() {
        Seat seat1 = new Seat("A1", SeatCategory.REGULAR, 100);
        Seat seat2 = new Seat("B1", SeatCategory.VIP, 200);
        assertThat(seat1).isNotEqualTo(seat2);
    }
}