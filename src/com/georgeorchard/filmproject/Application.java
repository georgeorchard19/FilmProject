package com.georgeorchard.filmproject;

import com.georgeorchard.filmproject.collection.MediaLog;
import com.georgeorchard.filmproject.collection.WatchList;
import com.georgeorchard.filmproject.menu.MainMenu;
import com.georgeorchard.filmproject.model.Media;
import com.georgeorchard.filmproject.source.SampleMediaLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

        public static void main (String[]args) {

            Scanner scanner = new Scanner(System.in);
            WatchList watchlist = new WatchList();
            MediaLog mediaLog = new MediaLog();
            ArrayList<Media> library = SampleMediaLibrary.setSampleLibrary();


            MainMenu menu = new MainMenu(scanner, watchlist, library, mediaLog);
            menu.setUp();
        }

}