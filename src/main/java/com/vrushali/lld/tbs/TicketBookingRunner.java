package com.vrushali.lld.tbs;

import com.vrushali.lld.tbs.model.*;
import com.vrushali.lld.tbs.repository.BookingRepository;
import com.vrushali.lld.tbs.repository.EventRepository;
import com.vrushali.lld.tbs.repository.SeatInventoryRepository;
import com.vrushali.lld.tbs.repository.ShowTimeRepository;
import com.vrushali.lld.tbs.service.BookingService;
import com.vrushali.lld.tbs.service.CancellationService;
import com.vrushali.lld.tbs.service.SearchService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TicketBookingRunner {
    public static void main(String[] args) {

        // Repositories

        EventRepository eventRepository = new EventRepository();
        ShowTimeRepository showTimeRepository = new ShowTimeRepository();
        SeatInventoryRepository seatInventoryRepository = new SeatInventoryRepository();
        BookingRepository bookingRepository = new BookingRepository();

        // Services

        SearchService searchService = new SearchService(eventRepository, showTimeRepository,
                seatInventoryRepository);

        BookingService bookingService = new BookingService(bookingRepository, seatInventoryRepository, showTimeRepository);
        CancellationService cancellationService = new CancellationService(bookingRepository, seatInventoryRepository);

        // create venue with SeatMap
        Map<String, Seat> seatMap = Map.of(
                "A1", new Seat("A1", SeatCategory.REGULAR, 100),
                "A2", new Seat("A2", SeatCategory.PREMIUM, 150),
                "A3", new Seat("A3", SeatCategory.VIP, 200)
        );

        // Add Event
        Event event = new Event("E001", "Avengers: Endgame", EventType.MOVIE);
        eventRepository.save(event);

        // Add showtime
        ShowTime showTime = new ShowTime("ST001", event.getId(), "VENUE1",
                LocalDateTime.now(), LocalDateTime.now().plusHours(4));

        showTimeRepository.save(showTime);

        // Add SeatInventory for showTime
        SeatInventory inventory = new SeatInventory(showTime.getId(), seatMap);
        seatInventoryRepository.save(inventory);

        // ====== simulate flow ========//
        System.out.println("🎬 All Events:");

        List<Event> eventList = searchService.listAllEvents();
        for (Event e : eventList) {
            System.out.println(" - " + e.getName() + " (" + e.getEventType() + ")");
        }

        System.out.println("\n⏰ ShowTimes for Avengers:");
        List<ShowTime> showTimeList = searchService.getShowTimesForEvent("E001");

        for (ShowTime st : showTimeList) {
            System.out.println(" - " + st.getId() + " from " + st.getStartTime() + " to " + st.getEndTime());
        }

        System.out.println("\n🪑 Available Seats for ST001:");
        List<String> availableSeats = searchService.getAvailableSeatIds("ST001");
        availableSeats.forEach(seatId -> System.out.println(" - " + seatId));

        // Book seats
        String userId = "U001";
        List<String> seatsToBook = List.of("A1", "A2");
        Booking booking = bookingService.bookSeats(userId, "ST001", seatsToBook);
        System.out.println("\n✅ Booking Confirmed! ID: " + booking.getId());

        // View updated seat inventory
        System.out.println("\n🪑 Seats after booking:");
        searchService.getAvailableSeatIds("ST001").forEach(seatId -> System.out.println(" - " + seatId));

        // Cancel booking
        cancellationService.cancelBooking(booking.getId());
        System.out.println("\n❌ Booking Cancelled: " + booking.getId());

        // View available seats again
        System.out.println("\n🪑 Seats after cancellation:");
        searchService.getAvailableSeatIds("ST001").forEach(seatId -> System.out.println(" - " + seatId));
    }
}
