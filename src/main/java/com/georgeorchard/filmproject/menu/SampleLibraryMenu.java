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
        System.out.println("4 - Exit Menu");
    }

    @Override
    protected boolean handleChoice(int choice){

            switch (choice) {
                case 1 -> displaySampleMovieLibrary();
                case 2 -> displaySampleTVShowLibrary();
                case 3 -> displaySampleDocumentaryLibrary();
                case 4 -> {return false;}
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

        ArrayList<TVShow> TVShows = SampleMediaLibrary.getTVshows(getSampleLibrary());

        for (TVShow tv : TVShows) {
            System.out.println(tv);
            System.out.println();
        }
    }

    private void displaySampleDocumentaryLibrary() {
        System.out.println("Below is a list of sample Documentaries and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<Documentary> Docs = SampleMediaLibrary.getDocs(getSampleLibrary());

        for (Documentary doc : Docs) {
            System.out.println(doc);
            System.out.println();
        }
    }
}
