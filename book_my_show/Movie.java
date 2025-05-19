package book_my_show;

import java.util.List;


public class Movie
{
    private String movieId;

    private String title;

    private int duration;

    private String language;

    private List<String> genres;


    public Movie( final String movieId,
                  final String title,
                  final int duration,
                  final String language,
                  final List<String> genres )
    {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
        this.language = language;
        this.genres = genres;
    }


    public String getMovieId()
    {
        return movieId;
    }


    public void setMovieId( final String movieId )
    {
        this.movieId = movieId;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( final String title )
    {
        this.title = title;
    }


    public int getDuration()
    {
        return duration;
    }


    public void setDuration( final int duration )
    {
        this.duration = duration;
    }


    public String getLanguage()
    {
        return language;
    }


    public void setLanguage( final String language )
    {
        this.language = language;
    }


    public List<String> getGenres()
    {
        return genres;
    }


    public void setGenres( final List<String> genres )
    {
        this.genres = genres;
    }
}
