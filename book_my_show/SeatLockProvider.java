package book_my_show;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class SeatLockProvider
{
    private Map<Show, Map<Seat, SeatLock>> locks = new HashMap<>();


    public void lockSeat( Seat seat,
                          Show show,
                          String userId,
                          long durationMillis )
    {
        locks.putIfAbsent( show, new HashMap<>() );
        Map<Seat, SeatLock> showLocks = locks.get( show );

        if ( showLocks.containsKey( seat ) && !showLocks.get( seat ).isLockExpired() )
        {
            throw new RuntimeException( "Seat is already locked by another user" );
        }

        showLocks.put( seat, new SeatLock( seat, show, userId, System.currentTimeMillis() + durationMillis ) );
    }


    public boolean validateLock( Seat seat,
                                 Show show,
                                 String userId )
    {

        SeatLock lock = locks.getOrDefault( show, Collections.emptyMap() ).get( seat );
        if ( lock == null )
        {
            return true;
        }
        return lock != null && !lock.isLockExpired() && lock.getLockedBy().equals( userId );
    }


    public void removeExpiredLocks( Show show )
    {
        if ( !locks.containsKey( show ) )
        {
            return;
        }
        Map<Seat, SeatLock> showLocks = locks.get( show );
        showLocks.entrySet().removeIf( entry -> entry.getValue().isLockExpired() );
    }
}
