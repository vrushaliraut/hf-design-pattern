package com.vrushali.lld.tbs.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class VenueTest {
    private Venue venue;
    private Map<String, Seat> seatMap;

    @BeforeEach
    void setUp() {
        seatMap = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150)
        );

        venue = new Venue("V001", "PVR Andheri", seatMap);
    }

    @Test
    void shouldCreateVenueWithCorrectFields() {
        assertThat(venue.getId()).isEqualTo("V001");
        assertThat(venue.getName()).isEqualTo("PVR Andheri");
        assertThat(venue.getSeatMap()).isEqualTo(seatMap);
    }

    @Test
    void shouldContainAllExpectedSeatsInSeatMap() {
        assertThat(venue.getSeatMap()).containsKeys("A1", "A2");
        assertThat(venue.getSeatMap().get("A1").getCategory()).isEqualTo(SeatCategory.REGULAR);
    }
}