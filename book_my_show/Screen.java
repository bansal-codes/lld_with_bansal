package book_my_show;

import java.util.List;


public class Screen
{
    private String screenId;

    private List<Seat> seats;


    public Screen( final String screenId,
                   final List<Seat> seats )
    {
        this.screenId = screenId;
        this.seats = seats;
    }


    public String getScreenId()
    {
        return screenId;
    }


    public void setScreenId( final String screenId )
    {
        this.screenId = screenId;
    }


    public List<Seat> getSeats()
    {
        return seats;
    }


    public void setSeats( final List<Seat> seats )
    {
        this.seats = seats;
    }
}
