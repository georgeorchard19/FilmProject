package com.georgeorchard.filmproject.menu;

import com.georgeorchard.filmproject.collection.MediaLog;
import com.georgeorchard.filmproject.collection.WatchList;
import com.georgeorchard.filmproject.model.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends Menu {

    //TODO Add way to sort watchlist by year, alphabetically, group by genre, etc - COMPARATOR GENERICS
    private final WatchList watchList;
    private final MediaLog mediaLog;


    public MainMenu(Scanner scanner, WatchList watchList, ArrayList<Media> sampleLibrary, MediaLog mediaLog) {
        super(scanner, sampleLibrary);
        this.watchList = watchList;
        this.mediaLog = mediaLog;

        System.out.println("***************************");
        System.out.println("Welcome to my Media Project");
        System.out.println("***************************\n");

    }

    @Override
    protected void setMenu() {

        System.out.println("1 - View Sample Media");
        System.out.println("2 - WatchList");
        System.out.println("3 - LoggedMedia");
        System.out.println("4 - EXIT");
    }

    @Override
    protected boolean handleChoice(int choice) {
        switch (choice) {
            case 1 -> {
                SampleLibraryMenu sampleLibraryMenu = new SampleLibraryMenu(getScanner(), getSampleLibrary());
                sampleLibraryMenu.setUp();
            }
            case 2 -> {
                WatchListMenu watchListMenu = new WatchListMenu(getScanner(), getSampleLibrary(), watchList);
                watchListMenu.setUp();
            }
            case 3 -> {
                MediaLogMenu logMenu = new MediaLogMenu(getScanner(), getSampleLibrary(), mediaLog, watchList);
                logMenu.setUp();
            }
            case 4 -> {
                System.out.println("Thank you!");
                return false;
            }
            default -> System.out.println("Number inputted is out of range! Input a correct number!\n");
        }
        return true;
    }
}



