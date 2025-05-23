package com.vrushali.lld.tbs.model;

public class Event {
    private final String id;
    private final String name;
    private final EventType eventType;

    public Event(String id, String name, EventType eventType) {
        this.id = id;
        this.name = name;
        this.eventType = eventType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return eventType;
    }
}
