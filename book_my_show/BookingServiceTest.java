package book_my_show;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookingServiceTest
{
    public static void main(String[] args) throws InterruptedException {
        // --- Step 1: Setup Static Structure ---

        // Create seats (fixed layout of the screen)
        Seat seat1 = new Seat(1, SeatType.REGULAR);
        Seat seat2 = new Seat(2, SeatType.VIP);
        List<Seat> seats = Arrays.asList(seat1, seat2);

        // Create screen
        Screen screen = new Screen("ODI1", seats);

        // Create theater and assign screen
        Theater theater = new Theater("PVR Cinemas", "Downtown Mall");
        theater.getScreens().add(screen);

        // Create city and assign theater
        City city = new City("Agra");
        city.getThreaters().add(theater);

        // --- Step 2: Create Movie & Show (dynamic) ---
        Movie movie = new Movie("MOV123", "Inception", 148, "English", Arrays.asList("Sci-Fi", "Thriller"));

        Show show = new Show("101", movie, new Date(), screen);

        Map<String, Show> allShows = new HashMap<>();
        allShows.put(show.getShowId(), show);

        show.getSeatAvailability().put(seat1, SeatStatus.AVAILABLE);
        show.getSeatAvailability().put(seat2, SeatStatus.AVAILABLE);

        Map<SeatType, Double> pricing = new HashMap<>();
        pricing.put(SeatType.REGULAR, 150.0);
        pricing.put(SeatType.VIP, 250.0);
        show.setSeatPricing(pricing);

        // --- Step 3: Create User ---
        User user = new User("user001", "John Doe", "john@example.com", "1234567890");

        // --- Step 4: Services ---
        SeatLockProvider lockProvider = new SeatLockProvider();
        BookingService bookingService = new BookingService(lockProvider);

        // --- Step 5: Lock Seats ---
        System.out.println("Locking seats...");
        lockProvider.lockSeat( seat1, show, user.getUserId(), 10 * 1000 ); // 10 minutes
        lockProvider.lockSeat( seat2, show, user.getUserId(), 10 * 1000 );

        // --- Step 6: Book Seats ---
        System.out.println("Creating booking...");
        Booking booking = bookingService.createBooking(user, show, seats);
        System.out.println("Booking Confirmed:");
        System.out.println("Total Price: " + booking.getTotalPrice());
        System.out.println("Status: " + booking.getStatus());

        // --- Step 7: Cancel Booking ---
        System.out.println("Cancelling booking...");
        bookingService.cancelBooking(booking);
        System.out.println("Booking Cancelled. Status: " + booking.getStatus());
        System.out.println("Total Price: " + booking.getTotalPrice());

        // --- Step 8: Test Lock Expiry ---
        System.out.println("Testing lock expiry...");
        lockProvider.lockSeat(seat1, show, user.getUserId(), 1000); // 1 sec
        Thread.sleep(1500);
        try {
            lockProvider.lockSeat(seat1, show, "anotherUser", 1000);
            System.out.println("Lock acquired by another user after expiry");
        } catch (RuntimeException e) {
            System.out.println("Lock still valid or not expired");
        }

        // --- Step 9: City & Theater Info ---
        System.out.println("\n--- City & Theater Info ---");
        System.out.println("City: " + city.getName());
        System.out.println("Theater: " + theater.getName());
        System.out.println("Movie Playing: " + show.getMovie().getTitle());
        System.out.println("Seat Types and Prices:");
        for (Seat seat : seats) {
            System.out.println("Seat " + seat.getSeatNumber() + " (" + seat.getType() + "): " + show.getPriceForSeat(seat));
        }
    }
}
