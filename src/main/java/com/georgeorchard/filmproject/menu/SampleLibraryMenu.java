package com.georgeorchard.filmproject.menu;

import com.georgeorchard.filmproject.model.Documentary;
import com.georgeorchard.filmproject.model.Media;
import com.georgeorchard.filmproject.model.Movie;
import com.georgeorchard.filmproject.model.TVShow;
import com.georgeorchard.filmproject.source.SampleMediaLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleLibraryMenu extends Menu {


    public SampleLibraryMenu(Scanner scanner, ArrayList<Media> sampleMediaLibrary) {
        super(scanner, sampleMediaLibrary);
    }

    @Override
    protected void setMenu() {
        System.out.println("\n--- Sample Library Options ---");
        System.out.println("1 - List of sample Movies");
        System.out.println("2 - List of sample TV shows");
        System.out.println("3 - List of sample Documentaries");
        System.out.println("4 - Search Library by title");
        System.out.println("5 - Exit Menu");
    }

    @Override
    protected boolean handleChoice(int choice) {

        switch (choice) {
            case 1 -> displaySampleMovieLibrary();
            case 2 -> displaySampleTVShowLibrary();
            case 3 -> displaySampleDocumentaryLibrary();
            case 4 -> displaySearchByTitle();
            case 5 -> {
                return false;
            }
            default -> System.out.println("Number inputted is out of range! Input a correct number!\n");
        }
        return true;
    }


    private void displaySampleMovieLibrary() {
        System.out.println("Below is a list of sample movies and accepted formats:");
        System.out.println("*******************************************************");
        //enhanced for loop for moving through the array of sample, for each movie object, we print it out
        ArrayList<Movie> movies = SampleMediaLibrary.getMovies(getSampleLibrary());

        for (Movie movie : movies) {
            System.out.println(movie);
            System.out.println();
        }

        System.out.println("Total Movies in sample " + movies.size());

    }

    private void displaySampleTVShowLibrary() {
        System.out.println("Below is a list of sample TV Shows and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<TVShow> tvShows = SampleMediaLibrary.getTVShows(getSampleLibrary());

        for (TVShow tv : tvShows) {
            System.out.println(tv);
            System.out.println();
        }
    }

    private void displaySampleDocumentaryLibrary() {
        System.out.println("Below is a list of sample Documentaries and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<Documentary> docs = SampleMediaLibrary.getDocs(getSampleLibrary());

        for (Documentary doc : docs) {
            System.out.println(doc);
            System.out.println();
        }
    }

    private void displaySearchByTitle() {
        String userSearch = promptUser("input text to search Title: ");

        while (userSearch.isBlank()){
            userSearch = promptUser("ERROR! Please type a string!!");
        }

        ArrayList<Media> results = SampleMediaLibrary.searchLibraryByTitle(userSearch, getSampleLibrary());

        if (results.isEmpty()) {
            System.out.println("Search returned no results!");
            return;
        }
        System.out.println("Below is a list of sample Media containing: " + userSearch);
        System.out.println("*******************************************************");

        for (Media media : results) {
            System.out.println(media.getSummary());
            System.out.println();
        }
    }
}

