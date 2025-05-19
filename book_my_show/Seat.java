package book_my_show;

import java.util.Objects;


public class Seat
{
    private int seatNumber;

    private SeatType type;


    public Seat( int seatNumber,
                 SeatType type )
    {
        this.seatNumber = seatNumber;
        this.type = type;
    }


    public int getSeatNumber()
    {
        return seatNumber;
    }


    public SeatType getType()
    {
        return type;
    }


    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass() )
        {
            return false;
        }
        Seat seat = (Seat) obj;
        return seatNumber == seat.seatNumber && type == seat.type;
    }


    @Override
    public int hashCode()
    {
        return Objects.hash( seatNumber, type );
    }
}
