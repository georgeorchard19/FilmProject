package com.georgeorchard.filmproject.menu;

import com.georgeorchard.filmproject.collection.MediaLog;
import com.georgeorchard.filmproject.collection.WatchList;
import com.georgeorchard.filmproject.exception.DuplicateMediaException;
import com.georgeorchard.filmproject.exception.InvalidRatingException;
import com.georgeorchard.filmproject.exception.MediaNotFoundException;
import com.georgeorchard.filmproject.model.Media;
import com.georgeorchard.filmproject.source.SampleMediaLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class MediaLogMenu extends Menu {

    private final MediaLog mediaLog;
    private final WatchList watchList;

    public MediaLogMenu(Scanner scanner, ArrayList<Media> sampleMediaLibrary, MediaLog mediaLog, WatchList watchList) {
        super(scanner, sampleMediaLibrary);
        this.mediaLog = mediaLog;
        this.watchList = watchList;
    }

    @Override
    protected void setMenu() {
        System.out.println("\n--- Watch Log Options ---");
        System.out.println("1 - View current log");
        System.out.println("2 - Add to watch-log");
        System.out.println("3 - Sort log by title");
        System.out.println("4 - Check average rating of log");
        System.out.println("5 - Exit Menu");
    }

    @Override
    protected boolean handleChoice(int choice) {
            switch (choice) {
                case 1 -> showLog();
                case 2 -> addToLog();
                case 3 -> {
                    mediaLog.sortByTitle();
                    showLog();
                }
                case 4 -> System.out.printf("Average Rating of Log: %.1f", mediaLog.getAverageRating());
                case 5 -> {return false;}
                default -> System.out.println("Number inputted is out of range! Input a correct number!\n");
            }
            return true;
        }

    public void showLog() {
        mediaLog.printList();
    }

    public void addToLog() {

        String input = promptUser(String.format("Enter what you would like to add to your log: (e.g. Gladiator, 7.7) Rating must be between %.1f and %.1f ", Media.MIN_RATING, Media.MAX_RATING));

        String[] args = input.split(",");

        if (args.length != 2) {
            System.out.println("invalid format, please use: Title, Rating");
            return;
        }
        String inputTitle = args[0].trim();
        double rating;

        try {
            rating = Double.parseDouble(args[1].trim());
        } catch (NumberFormatException ex) {
            System.out.println("Rating must be valid number!");
            return;
        }

        try {
            if (mediaLog.isInList(inputTitle)) {
                String storedTitle = mediaLog.updateRating(inputTitle, rating);
                System.out.printf("%s: updated rating to %.1f", storedTitle, rating);
                return;
            }

            Media media = SampleMediaLibrary.findMediaInLibrary(inputTitle, getSampleLibrary());
            media.setPersonalRating(rating);
            mediaLog.addMedia(media);


            if (watchList.isInList(inputTitle)) {
                watchList.removeMedia(inputTitle);
            }

            System.out.printf("%s added to log with %.1f rating%n", media.getTitle(), rating);

        } catch (InvalidRatingException | DuplicateMediaException | MediaNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
