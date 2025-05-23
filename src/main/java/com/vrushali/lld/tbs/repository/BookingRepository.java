package com.vrushali.lld.tbs.repository;

import com.vrushali.lld.tbs.model.Booking;

import java.util.*;
import java.util.stream.Collectors;

public class BookingRepository {
    private final Map<String, Booking> bookingStore = new HashMap<>();

    // save	Add or update a booking
    public void save(Booking booking) {
        bookingStore.put(booking.getId(), booking);
    }

    // findById	Fetch booking by booking ID
    public Optional<Booking> findByBookingId(String id) {
        return Optional.ofNullable(bookingStore.get(id));
    }

    // findAll	Return all bookings
    public List<Booking> findAll() {
        return new ArrayList<>(bookingStore.values());
    }


    // findByUserId	Return all bookings made by a specific user
    public List<Booking> findByUserId(String userId) {
        return bookingStore.values().stream()
                .filter(b -> b.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    // findByShowTimeId	Return all bookings for a given showtime
    public List<Booking> findByShowTimeId(String showTimeId) {
        Collection<Booking> bookings = bookingStore.values();
        List<Booking> bookingList = bookings.stream()
                .filter(b -> b.getShowTimeId().equals(showTimeId))
                .collect(Collectors.toList());
        return bookingList;
    }

    // deleteById Remove a booking
    public void deleteById(String id) {
        bookingStore.remove(id);
    }

    // clear - Clear in-memory store (used in tests)
    public void clear() {
        bookingStore.clear();
    }
}
