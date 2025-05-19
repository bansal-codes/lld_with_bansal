package book_my_show;

import java.util.ArrayList;
import java.util.List;


public class User
{
    private String userId;

    private String name;

    private String email;

    private String phoneNumber;

    private List<Booking> bookings = new ArrayList<>();


    public User( final String userId,
                 final String name,
                 final String email,
                 final String phoneNumber )
    {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookings = new ArrayList<>();
    }


    public String getUserId()
    {
        return userId;
    }


    public List<Booking> getBookings()
    {
        return bookings;
    }
}
