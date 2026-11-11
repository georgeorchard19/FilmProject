package com.georgeorchard.filmproject.model;

public class Movie extends Media {

    private final String actors;
    private final String plot; //final as cannot be changed
    private final String director; //final as cannot be changed
    private final int oscars;

    //SET CONSTRUCTOR Movie Object instance that is created
    public Movie(String title, int year, String genre, String actors, String plot, String director, int oscars, double rating) {
        super(title, year,genre, rating);
        this.actors = actors;
        this.plot = plot;
        this.director = director;
        this.oscars = oscars;
    }

    public String getActors(){
        return this.actors;
    }
    public String getPlot(){
        return this.plot;
    }
    public String getDirector(){
        return this.director;
    }
    public int getOscars(){
        return this.oscars;
    }

    @Override
    public String toString(){
        return String.format("%s (%d) | %s | Director: %s | %s | %.1f/%.0f \nPLOT: %s",
            getTitle(), getYear(), getGenre(), director, actors, getRating(), Media.MAX_SOURCE_RATING, plot);
    }

    public String getSummary(){
        return String.format("%s | %s | %s | %.1f/%.0f", getTitle(), director, getGenre(), getRating(), Media.MAX_SOURCE_RATING);
    }

}
