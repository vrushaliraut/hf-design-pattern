package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.ShowTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShowTimeRepositoryTest {

    private ShowTimeRepository showTimeRepository;

    @BeforeEach
    void setUp() {
        showTimeRepository = new ShowTimeRepository();
    }

    @Test
    void shouldSaveAndRetrievedShowTime() {
        ShowTime showTime = new ShowTime("ST001", "E001", "V001",
                LocalDateTime.of(2025, 5, 25, 18, 0),
                LocalDateTime.of(2025, 5, 25, 20, 0));

        showTimeRepository.save(showTime);

        assertThat(showTimeRepository.findById("ST001")).isPresent().contains(showTime);
    }

    @Test
    void shouldReturnAllShowTimes() {
        ShowTime s1 = new ShowTime("ST001", "E001", "V001", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        ShowTime s2 = new ShowTime("ST002", "E002", "V002", LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        showTimeRepository.save(s1);
        showTimeRepository.save(s2);

        assertThat(showTimeRepository.findAll()).hasSize(2).containsExactlyInAnyOrder(s1, s2);
    }

    @Test
    void shouldFindShowTimeByEventId() {
        ShowTime s1 = new ShowTime("ST001", "E001", "V001", LocalDateTime.now(),
                LocalDateTime.now().plusHours(1));

        ShowTime s2 = new ShowTime("ST002", "E001", "V002", LocalDateTime.now(),
                LocalDateTime.now().plusHours(2));

        ShowTime s3 = new ShowTime("ST003", "E003", "V003", LocalDateTime.now(),
                LocalDateTime.now().plusHours(3));

        showTimeRepository.save(s1);
        showTimeRepository.save(s2);
        showTimeRepository.save(s3);

        List<ShowTime> showTimeList = showTimeRepository.findEventById("E001");
        assertThat(showTimeList).hasSize(2).containsExactlyInAnyOrder(s1, s2);
    }

    @Test
    void shouldDeleteShowTimeById() {
        ShowTime showTime = new ShowTime("ST001", "E001", "V001", LocalDateTime.now(), LocalDateTime.now().plusHours(1));

        showTimeRepository.save(showTime);
        showTimeRepository.deleteById("ST001");

        assertThat(showTimeRepository.findById("ST001")).isEmpty();
    }
}