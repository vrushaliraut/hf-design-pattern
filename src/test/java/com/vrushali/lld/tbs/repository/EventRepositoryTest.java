package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.Event;
import com.vrushali.lld.tbs.model.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class EventRepositoryTest {

    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        eventRepository = new EventRepository();
    }

    @Test
    void shouldSaveAndRetrieveEvent() {
        Event event = new Event("E1001", "Avengers", EventType.MOVIE);

        eventRepository.save(event);

        assertThat(eventRepository.findById("E1001")).isPresent().contains(event);
    }

    @Test
    void shouldReturnAllEvents() {
        Event event1 = new Event("E1001", "Avengers", EventType.MOVIE);
        Event event2 = new Event("E1002", "Cold Play", EventType.CONCERT);

        eventRepository.save(event1);
        eventRepository.save(event2);

        List<Event> eventList = eventRepository.findAll();
        assertThat(eventList).hasSize(2).containsExactlyInAnyOrder(event1, event2);
    }

    @Test
    void shouldDeleteEventById(){
        Event event1 = new Event("E1001", "Avengers", EventType.MOVIE);
        eventRepository.save(event1);

        eventRepository.deleteById("E1001");

        assertThat(eventRepository.findById("E1001")).isEmpty();
    }

}