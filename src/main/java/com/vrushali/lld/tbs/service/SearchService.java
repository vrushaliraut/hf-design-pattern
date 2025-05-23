package com.vrushali.lld.tbs.service;

import com.vrushali.lld.tbs.model.Event;
import com.vrushali.lld.tbs.model.SeatInventory;
import com.vrushali.lld.tbs.model.SeatStatus;
import com.vrushali.lld.tbs.model.ShowTime;
import com.vrushali.lld.tbs.repository.EventRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import com.vrushali.lld.tbs.repository.ShowTimeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* SearchService needs to collaborate with these repositories:

EventRepository

ShowTimeRepository

SeatInventoryRepository
* */
public class SearchService {
    private final EventRepository eventRepository;
    private final ShowTimeRepository showTimeRepository;
    private final SeatInventoryRepository seatInventoryRepository;

    public SearchService(EventRepository eventRepository,
                         ShowTimeRepository showTimeRepository,
                         SeatInventoryRepository seatInventoryRepository) {
        this.eventRepository = eventRepository;
        this.showTimeRepository = showTimeRepository;
        this.seatInventoryRepository = seatInventoryRepository;
    }

    public List<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventId(String id) {
        return eventRepository.findById(id);
    }

    public List<ShowTime> getShowTimesForEvent(String eventId) {
        return showTimeRepository.findEventById(eventId);
    }

    public List<String> getAvailableSeatIds(String showTimeId) {
        Optional<SeatInventory> byShowTimeId = seatInventoryRepository.findByShowTimeId(showTimeId);

        List<String> availableSeats = byShowTimeId
                .map(inventory -> inventory.getSeatStatusMap()
                        .entrySet().stream()
                        .filter(e -> e.getValue() == SeatStatus.AVAILABLE)
                        .map(e -> e.getKey())
                        .collect(Collectors.toList())
                )
                .orElse(List.of());

        return availableSeats;
    }
}
