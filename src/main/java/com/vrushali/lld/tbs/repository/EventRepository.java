package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.Event;

import java.util.*;

/*
Store and manage Event entities.

Support basic operations: save, get, findAll, delete.


* This is a Repository Pattern:
Abstracts data access (even if it's just in-memory).
Keeps model layer free from storage concerns.
Can be swapped later (e.g., for database or REST backend).
* */

public class EventRepository {
    private final Map<String, Event> eventStore = new HashMap<>();

    public void save(Event event) {
        eventStore.put(event.getId(), event);
    }

    public Optional<Event> findById(String id) {
        return Optional.ofNullable(eventStore.get(id));
    }

    public List<Event> findAll() {
        return new ArrayList<>(eventStore.values());
    }

    public void deleteById(String id) {
        eventStore.remove(id);
    }

    public void clear() {
        eventStore.clear();
    }

}
