package com.georgeorchard.filmproject.model;

public class Documentary extends Media {

    private final String topic;
    private final String narrator;

    public Documentary(String title, int year, String genre, double rating, String topic, String narrator) {
        super(title, year, genre, rating);
        this.topic = topic;
        this.narrator = narrator;
    }

    public String getTopic(){
        return this.topic;
    }

    public String getNarrator(){
        return this.narrator;
    }


    @Override
    public String toString(){
        return String.format("%s (%d) | %s | Narrator: %s | %s | %.1f/%.0f",
                getTitle(), getYear(), getGenre(), narrator, topic, getRating(), Media.MAX_RATING);
    }

    @Override
    public String getSummary(){
        return String.format("%s | %s | %s | %.1f/%.0f", getTitle(), narrator, topic, getRating(), Media.MAX_RATING);
    }


}
