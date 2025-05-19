package book_my_show;

import java.util.Date;

public class SeatLock
{
    private Seat seat;

    private Show show;

    private String lockedBy;

    private Date lockTime;

    private long timeoutInSeconds;


    public SeatLock( Seat seat,
                     Show show,
                     String lockedBy,
                     long timeoutInSeconds )
    {
        this.seat = seat;
        this.show = show;
        this.lockedBy = lockedBy;
        this.lockTime = new Date();
        this.timeoutInSeconds = timeoutInSeconds;
    }


    public boolean isLockExpired()
    {
        long currentTime = System.currentTimeMillis();
        long lockTimeMillis = lockTime.getTime();
        return lockTimeMillis < currentTime;
    }


    public Seat getSeat()
    {
        return seat;
    }


    public Show getShow()
    {
        return show;
    }


    public String getLockedBy()
    {
        return lockedBy;
    }


    public Date getLockTime()
    {
        return lockTime;
    }
}
