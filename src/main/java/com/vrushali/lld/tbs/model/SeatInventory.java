package com.vrushali.lld.tbs.model;

import java.util.HashMap;
import java.util.Map;

public class SeatInventory {
    private final String showTimeId;
    private final Map<String, SeatStatus> seatStatusMap;

    public SeatInventory(String showTimeId, Map<String, Seat> seatMap) {
        this.showTimeId = showTimeId;
        this.seatStatusMap = new HashMap<>();
        for (String seatId : seatMap.keySet()) {
            seatStatusMap.put(seatId, SeatStatus.AVAILABLE);
        }
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public Map<String, SeatStatus> getSeatStatusMap() {
        return seatStatusMap;
    }

    public SeatStatus getSeatStatus(String seatId) {
        return seatStatusMap.getOrDefault(seatId, null);
    }

    public void setSeatStatus(String seatId, SeatStatus status) {
        seatStatusMap.put(seatId, status);
    }
}
