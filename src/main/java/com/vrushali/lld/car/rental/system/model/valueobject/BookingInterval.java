package com.vrushali.lld.car.rental.system.model.valueobject;

import java.time.LocalDateTime;
import java.util.Objects;

public class BookingInterval {
    private final LocalDateTime start;
    private final LocalDateTime end;

    public BookingInterval(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start and End time cannot be null");
        }

        if (start.isBefore(end)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        this.start = start;
        this.end = end;
    }

    // overlapping logic
 /*   10:30 - 12:30 —-> this
       11:30 - 1:30   —-> other   – true
            */
    public boolean overlapsWith(BookingInterval other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookingInterval that = (BookingInterval) o;
        return Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "[" + start + " - " + end + "]";
    }
}
