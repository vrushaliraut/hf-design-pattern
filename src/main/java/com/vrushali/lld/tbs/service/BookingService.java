package com.vrushali.lld.tbs.service;

import com.vrushali.lld.tbs.Exception.SeatAlreadyBookedException;
import com.vrushali.lld.tbs.Exception.ShowTimeNotFoundException;
import com.vrushali.lld.tbs.model.Booking;
import com.vrushali.lld.tbs.model.SeatInventory;
import com.vrushali.lld.tbs.model.SeatStatus;
import com.vrushali.lld.tbs.repository.BookingRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import com.vrushali.lld.tbs.repository.ShowTimeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
* BookingService! This will be the core service responsible for handling ticket reservations:
*  validating input,
* checking seat availability, creating bookings, and updating seat inventory.
*
* | Method                                   | Description                                               |
| ---------------------------------------- | --------------------------------------------------------- |
| `bookSeats(userId, showTimeId, seatIds)` | Books the requested seats for the given showtime and user |

* */
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatInventoryRepository seatInventoryRepository;
    private final ShowTimeRepository showTimeRepository;

    public BookingService(BookingRepository bookingRepository,
                          SeatInventoryRepository seatInventoryRepository,
                          ShowTimeRepository showTimeRepository) {
        this.bookingRepository = bookingRepository;
        this.seatInventoryRepository = seatInventoryRepository;
        this.showTimeRepository = showTimeRepository;
    }

    public Booking bookSeats(String userId, String showTimeId, List<String> seatIds) {
        // Validate showTime Exists
        if (showTimeRepository.findById(showTimeId).isEmpty()) {
            throw new ShowTimeNotFoundException("ShowTime not found: " + showTimeId);
        }

        // Fetch Seat Inventory
        Optional<SeatInventory> optionalSeatInventory = seatInventoryRepository.findByShowTimeId(showTimeId);

        if (optionalSeatInventory.isEmpty()) {
            throw new IllegalStateException("Seat inventory not found for showTimeId: " + showTimeId);
        }

        SeatInventory seatInventory = optionalSeatInventory.get();

        // Check all requested seats are available
        for (String seatId : seatIds) {
            SeatStatus seatStatus = seatInventory.getSeatStatus(seatId);
            if (seatStatus == null) {
                throw new IllegalArgumentException("Seat" + seatId + " does not exists");
            }

            if (seatStatus == SeatStatus.BOOKED) {
                throw new SeatAlreadyBookedException("Seat already booked: " + seatId);
            }
        }

        // All Good mark seat as book
        for (String seatId : seatIds) {
            seatInventory.setSeatStatus(seatId, SeatStatus.BOOKED);
        }

        // save updated inventory
        seatInventoryRepository.save(seatInventory);

        // Create booking
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, userId, showTimeId, seatIds);
        bookingRepository.save(booking);

        return booking;
    }
}
