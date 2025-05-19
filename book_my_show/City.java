package book_my_show;

import java.util.ArrayList;
import java.util.List;


public class City
{
    private String name;

    private List<Theater> theaters;


    public String getName()
    {
        return name;
    }


    public void setName( final String name )
    {
        this.name = name;
    }


    public City( final String name )
    {
        this.name = name;
        this.theaters = new ArrayList<>();
    }


    public List<Theater> getThreaters()
    {
        return theaters;
    }


    public void setThreaters( final List<Theater> theaters )
    {
        this.theaters = theaters;
    }
}
