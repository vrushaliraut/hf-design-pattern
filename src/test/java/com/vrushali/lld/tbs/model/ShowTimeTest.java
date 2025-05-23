package com.vrushali.lld.tbs.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShowTimeTest {

    @Test
    void shouldCreateShowTimeWithCorrectFields() {
        LocalDateTime start = LocalDateTime.of(2025, 5, 25, 18, 30);
        LocalDateTime end = LocalDateTime.of(2025, 5, 25, 21, 30);

        ShowTime showTime = new ShowTime("ST001", "E001", "V001", start, end);

        assertThat(showTime.getId()).isEqualTo("ST001");
        assertThat(showTime.getEventId()).isEqualTo("E001");
        assertThat(showTime.getVenueId()).isEqualTo("V001");
        assertThat(showTime.getStartTime()).isEqualTo(start);
        assertThat(showTime.getEndTime()).isEqualTo(end);
    }

}