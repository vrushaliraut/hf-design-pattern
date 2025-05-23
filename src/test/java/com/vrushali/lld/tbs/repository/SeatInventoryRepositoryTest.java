package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.Seat;
import com.vrushali.lld.tbs.model.SeatCategory;
import com.vrushali.lld.tbs.model.SeatInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeatInventoryRepositoryTest {
    private SeatInventoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new SeatInventoryRepository();
    }

    @Test
    void shouldSaveAndRetrieveInventoryByShowTimeId() {
        Map<String, Seat> seats = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.VIP, 300)
        );

        SeatInventory inventory = new SeatInventory("ST001", seats);
        repository.save(inventory);

        assertThat(repository.findByShowTimeId("ST001")).isPresent().contains(inventory);
    }

    @Test
    void shouldDeleteInventoryByShowTimeId() {
        Map<String, Seat> seats = Map.of("A1", new Seat("A1", SeatCategory.REGULAR, 100));
        repository.save(new SeatInventory("ST001", seats));

        repository.deleteByShowTimeId("ST001");

        assertThat(repository.findByShowTimeId("ST001")).isEmpty();
    }

    @Test
    void shouldClearAllInventory() {
        Map<String, Seat> seats = Map.of("A1", new Seat("A1", SeatCategory.REGULAR, 100));
        repository.save(new SeatInventory("ST001", seats));
        repository.save(new SeatInventory("ST002", seats));

        repository.clear();

        assertThat(repository.findByShowTimeId("ST001")).isEmpty();
        assertThat(repository.findByShowTimeId("ST002")).isEmpty();
    }
}