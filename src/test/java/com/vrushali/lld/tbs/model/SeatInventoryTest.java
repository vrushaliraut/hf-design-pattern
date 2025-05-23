package com.vrushali.lld.tbs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SeatInventoryTest {

    private SeatInventory seatInventory;

    @BeforeEach
    void setUp() {
        Map<String, Seat> mockSeats = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150),
                "A3", new Seat("A3", SeatCategory.VIP, 200)
        );

        seatInventory = new SeatInventory("show-001", mockSeats);
    }

    @Test
    void ShouldInitializeAllSeatsAsAvailable(){
        assertThat(seatInventory.getSeatStatus("A1")).isEqualTo(SeatStatus.AVAILABLE);
        assertThat(seatInventory.getSeatStatus("A2")).isEqualTo(SeatStatus.AVAILABLE);
        assertThat(seatInventory.getSeatStatus("A3")).isEqualTo(SeatStatus.AVAILABLE);
    }

    @Test
    void shouldUpdateSeatStatusToBooked(){
        seatInventory.setSeatStatus("A1", SeatStatus.BOOKED);
        assertThat(seatInventory.getSeatStatus("A1")).isEqualTo(SeatStatus.BOOKED);
    }

    @Test
    void shouldReturnNullForNonExistentSeat(){
        assertThat(seatInventory.getSeatStatus("Z9")).isNull();
    }
}