package com.vrushali.lld.tbs.model;

import java.time.LocalDateTime;

public class ShowTime {
    private final String id;
    private final String eventId;
    private final String venueId;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public ShowTime(String id, String eventId, String venueId,
                    LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.eventId = eventId;
        this.venueId = venueId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public String getEventId() {
        return eventId;
    }

    public String getVenueId() {
        return venueId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
