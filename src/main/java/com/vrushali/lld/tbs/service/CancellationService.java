package com.vrushali.lld.tbs.service;

/*
* to handle ticket cancellation and free up seats in the inventory.
* This complements the BookingService by managing the reversal of a reservation
*
* | Method                     | Description                                                   |
| -------------------------- | ------------------------------------------------------------- |
| `cancelBooking(bookingId)` | Cancels a booking and frees associated seats (mark AVAILABLE) |

* */

import com.vrushali.lld.tbs.Exception.BookingNotFoundException;
import com.vrushali.lld.tbs.model.Booking;
import com.vrushali.lld.tbs.model.SeatInventory;
import com.vrushali.lld.tbs.model.SeatStatus;
import com.vrushali.lld.tbs.repository.BookingRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;

import java.util.Optional;

public class CancellationService {
    private final BookingRepository bookingRepository;
    private final SeatInventoryRepository inventoryRepository;

    public CancellationService(BookingRepository bookingRepository,
                               SeatInventoryRepository inventoryRepository) {
        this.bookingRepository = bookingRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public void cancelBooking(String bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findByBookingId(bookingId);

        if (optionalBooking.isEmpty()) {
            throw new BookingNotFoundException("Booking not found: " + bookingId);
        }

        Booking booking = optionalBooking.get();

        // update seat status back to AVAILABLE
        SeatInventory seatInventory = inventoryRepository.findByShowTimeId(booking.getShowTimeId())
                .orElseThrow(() -> new IllegalStateException("Inventory not found for showTime"));

        for (String seatId : booking.getSeatIds()) {
            seatInventory.setSeatStatus(seatId, SeatStatus.AVAILABLE);
        }

        inventoryRepository.save(seatInventory);

        // Mark booking as cancelled
        booking.cancel();
        bookingRepository.save(booking);
    }
}
