package com.vrushali.lld.tbs.model;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private final String id;
    private final String userId;
    private final String showTimeId;
    private final List<String> seatIds;
    
    private BookingStatus status;

    private final LocalDateTime timestamp;

    public Booking(String id, String userId, String showTimeId,
                   List<String> seatIds) {
        this.id = id;
        this.userId = userId;
        this.showTimeId = showTimeId;
        this.seatIds = seatIds;
        this.status = BookingStatus.BOOKED;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowTimeId() {
        return showTimeId;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void cancel(){
        this.status = BookingStatus.CANCELLED;
    }
}
