package book_my_show;

import java.util.Date;
import java.util.List;


public class Booking
{
    private String bookingId;

    private Show show;

    private User user;

    private List<Seat> seats;

    private BookingStatus status;

    private Date bookingTime;

    private double totalPrice;


    public void setBookingId( String id )
    {
        this.bookingId = id;
    }


    public void setShow( Show show )
    {
        this.show = show;
    }


    public void setUser( User user )
    {
        this.user = user;
    }


    public void setSeats( List<Seat> seats )
    {
        this.seats = seats;
    }


    public void setStatus( BookingStatus status )
    {
        this.status = status;
    }


    public void setBookingTime( Date date )
    {
        this.bookingTime = date;
    }


    public void setTotalPrice( double price )
    {
        this.totalPrice = price;
    }


    public Show getShow()
    {
        return show;
    }


    public List<Seat> getSeats()
    {
        return seats;
    }


    public BookingStatus getStatus()
    {
        return status;
    }


    public double getTotalPrice()
    {
        return totalPrice;
    }
}
