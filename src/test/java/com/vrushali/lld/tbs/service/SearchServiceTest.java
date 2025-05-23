package com.vrushali.lld.tbs.service;

import com.vrushali.lld.tbs.model.*;
import com.vrushali.lld.tbs.repository.EventRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import com.vrushali.lld.tbs.repository.ShowTimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    private SearchService searchService;
    private EventRepository eventRepository;
    private ShowTimeRepository showTimeRepository;
    private SeatInventoryRepository seatInventoryRepository;


    @BeforeEach
    void setUp() {
        eventRepository = new EventRepository();
        showTimeRepository = new ShowTimeRepository();
        seatInventoryRepository = new SeatInventoryRepository();

        searchService = new SearchService(eventRepository, showTimeRepository, seatInventoryRepository);
    }

    @Test
    void shouldListAllEvents() {
        eventRepository.save(new Event("E001", "Avengers", EventType.MOVIE));
        eventRepository.save(new Event("E002", "Hamlet", EventType.PLAY));

        List<Event> events = searchService.listAllEvents();

        assertThat(events).hasSize(2);
    }

    @Test
    void shouldReturnShowTimesForEvent() {
        ShowTime showTime = new ShowTime("ST001", "E001", "V001", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        ShowTime showTime1 = new ShowTime("ST002", "E001", "V002", LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        ShowTime showTime2 = new ShowTime("ST003", "E002", "V001", LocalDateTime.now(), LocalDateTime.now().plusHours(3));

        showTimeRepository.save(showTime);
        showTimeRepository.save(showTime1);
        showTimeRepository.save(showTime2);

        List<ShowTime> showTimes = searchService.getShowTimesForEvent("E001");

        assertThat(showTimes).hasSize(2)
                .extracting("id")
                .containsExactlyInAnyOrder("ST001", "ST002");
    }

    @Test
    void shouldReturnAvailableSeatsForShowTime() {
        Map<String, Seat> seats = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150),
                "A3", new Seat("A3", SeatCategory.VIP, 200)
        );

        SeatInventory inventory = new SeatInventory("ST001", seats);
        inventory.setSeatStatus("A2", SeatStatus.BOOKED); // A2 is booked
        seatInventoryRepository.save(inventory);

        List<String> availableSeats = searchService.getAvailableSeatIds("ST001");

        assertThat(availableSeats).containsExactlyInAnyOrder("A1", "A3");
    }

}