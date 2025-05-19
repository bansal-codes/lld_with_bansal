package book_my_show;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class BookingService
{

    private SeatLockProvider seatLockProvider;


    public BookingService( SeatLockProvider lockProvider )
    {
        this.seatLockProvider = lockProvider;
    }


    public Booking createBooking( User user,
                                  Show show,
                                  List<Seat> requestedSeats )
    {
        synchronized ( show )
        {
            seatLockProvider.removeExpiredLocks( show );

            for ( Seat seat : requestedSeats )
            {
                if ( !seatLockProvider.validateLock( seat, show, user.getUserId() ) )
                {
                    throw new RuntimeException( "Seat not locked or locked by another user" );
                }
            }

            for ( Seat seat : requestedSeats )
            {
                show.getSeatAvailability().put( seat, SeatStatus.BOOKED );
            }

            double totalPrice = requestedSeats.stream()
                                              .mapToDouble( seat -> show.getPriceForSeat( seat ) )
                                              .sum();

            Booking booking = new Booking();
            booking.setBookingId( UUID.randomUUID().toString() );
            booking.setShow( show );
            booking.setSeats( requestedSeats );
            booking.setStatus( BookingStatus.CONFIRMED );
            booking.setBookingTime( new Date() );
            booking.setTotalPrice( totalPrice );
            booking.setUser( user );

            user.getBookings().add( booking );
            return booking;
        }
    }


    public void cancelBooking( Booking booking )
    {
        synchronized ( booking.getShow() )
        {
            for ( Seat seat : booking.getSeats() )
            {
                booking.getShow().getSeatAvailability().put( seat, SeatStatus.AVAILABLE );
            }
            booking.setStatus( BookingStatus.CANCELLED );
        }
    }
}
