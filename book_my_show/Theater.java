package book_my_show;

import java.util.ArrayList;
import java.util.List;


public class Theater
{
    private String name;

    private String address;

    private List<Screen> screens;


    public Theater( final String name,
                    final String address)
    {
        this.name = name;
        this.address = address;
        this.screens = new ArrayList<>();
    }


    public String getName()
    {
        return name;
    }


    public void setName( final String name )
    {
        this.name = name;
    }


    public String getAddress()
    {
        return address;
    }


    public void setAddress( final String address )
    {
        this.address = address;
    }


    public List<Screen> getScreens()
    {
        return screens;
    }


    public void setScreens( final List<Screen> screens )
    {
        this.screens = screens;
    }
}
