package com.georgeorchard.filmproject.model;

import com.georgeorchard.filmproject.exception.InvalidRatingException;

public abstract class Media implements Comparable<Media> {

    private final String title; // final as cannot be changed
    private final int year;
    private final String genre;
    private double rating; // not final as can change over time via API
    private double personalRating;
    public static final double MIN_RATING = 0.0;
    public static final double MAX_RATING = 10.0;

    public int compareTo (Media m){
        return title.compareTo(m.getTitle());
    }

    public Media (String title, int year, String genre, double rating){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle(){
        return this.title;
    }
    public int getYear(){
        return this.year;
    }
    public String getGenre(){
        return this.genre;
    }
    public double getRating(){
        return this.rating;
    }

    public void setPersonalRating(double personalRating) throws InvalidRatingException {
        if (personalRating < MIN_RATING || personalRating > MAX_RATING){
            throw new InvalidRatingException(String.format("Invalid Rating: %.1f! Must be between %.1f and %.1f", personalRating, MIN_RATING, MAX_RATING));
        }
            this.personalRating = personalRating;

    }

    public double getPersonalRating(){ //sets rating to whatever is passed in
        return personalRating;
    }

    public abstract String getSummary();
}
