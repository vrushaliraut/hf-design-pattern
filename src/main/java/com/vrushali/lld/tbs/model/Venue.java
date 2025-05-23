package com.vrushali.lld.tbs.model;

import java.util.Map;

public class Venue {
    private final String id;
    private final String name;
    private final Map<String, Seat> seatMap;  // seatId -> Seat

    public Venue(String id, String name, Map<String, Seat> seatMap) {
        this.id = id;
        this.name = name;
        this.seatMap = seatMap;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Seat> getSeatMap() {
        return seatMap;
    }
}
