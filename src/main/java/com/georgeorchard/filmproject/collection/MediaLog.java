package com.georgeorchard.filmproject.collection;

import com.georgeorchard.filmproject.exception.InvalidRatingException;
import com.georgeorchard.filmproject.exception.MediaNotFoundException;
import com.georgeorchard.filmproject.model.Media;

public class MediaLog extends MediaCollection {

public String updateRating(String title, double rating) throws InvalidRatingException, MediaNotFoundException {
    for (Media media: items){
        if (media.getTitle().equalsIgnoreCase(title)){
            media.setPersonalRating(rating);
            media.markAsSeen();
            return String.format("%s: updated rating to %.1f%n", media.getTitle(), rating);
        }
    }
    throw new MediaNotFoundException("Cannot Update as not seen yet!");
}

public double getAverageRating() {

    double sum = 0.0;

    if (items.isEmpty()){
        return 0.0;
    }

    for (Media media: items){

        sum += media.getPersonalRating();
    }

    return sum/items.size();

}


    @Override
    public void printList() {
        System.out.println("Log of rated Media:");

        for (Media media: items){
            System.out.println(media.getTitle() + " - Rating: " + media.getPersonalRating());
        }
    }
}
