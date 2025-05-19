package book_my_show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Show
{
    private String showId;

    private Movie movie;

    private Date startTime;

    private Screen screen;


    public Show( final String showId,
                 final Movie movie,
                 final Date startTime,
                 final Screen screen )
    {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
        this.screen = screen;
    }


    private Map<Seat, SeatStatus> seatAvailability = new HashMap<>();

    private Map<SeatType, Double> seatPricing = new HashMap<>(); // New pricing logic


    public Map<Seat, SeatStatus> getSeatAvailability()
    {
        return seatAvailability;
    }


    public void setSeatPricing( Map<SeatType, Double> pricing )
    {
        this.seatPricing = pricing;
    }


    public double getPriceForSeat( Seat seat )
    {
        return seatPricing.getOrDefault( seat.getType(), 0.0 );
    }


    public String getShowId()
    {
        return showId;
    }


    public void setShowId( final String showId )
    {
        this.showId = showId;
    }


    public Movie getMovie()
    {
        return movie;
    }


    public void setMovie( final Movie movie )
    {
        this.movie = movie;
    }


    public Date getStartTime()
    {
        return startTime;
    }


    public void setStartTime( final Date startTime )
    {
        this.startTime = startTime;
    }


    public Screen getScreen()
    {
        return screen;
    }


    public void setScreen( final Screen screen )
    {
        this.screen = screen;
    }
}
