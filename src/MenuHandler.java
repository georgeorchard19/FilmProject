import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuHandler {

    private Scanner scanner;
    private WatchList watchList;
    private ArrayList<Media> sampleLibrary;
    private MediaLog mediaLog;

    public MenuHandler() { //Constructor once called will create the 3 objects below without needing to pass in any parameters
        this.scanner = new Scanner(System.in); // creates it itself
        this.watchList = new WatchList();      // creates it itself
        this.sampleLibrary = SampleMediaLibrary.setSampleLibrary();
        this.mediaLog = new MediaLog();
    }

    private Media findMediaInLibrary(String title) throws MediaNotFoundException{
        for (Media media: sampleLibrary){
            if(media.getTitle().equalsIgnoreCase(title)){
                return media;
            }
        }
        throw new MediaNotFoundException("'" + "' Not in sample library!");
    }

    public void setMenu(){ //creates the initial menu design in the console
        System.out.println("If you would like to see a list of sample Movies, Input: 1");
        System.out.println("If you would like to see a list of sample TV shows, Input: 2");
        System.out.println("If you would like to see a list of sample Documentaries, Input: 3");
        System.out.println("If you would like to see your current watchlist, Input: 4");
        System.out.println("If you would like to add something to your  watchlist, Input: 5");
        System.out.println("If you would like to remove something from your  watchlist, Input: 6");
        System.out.println("If you would like to see your log of things seen and rated, Input 7");
        System.out.println("If you would like add to the watch-log  Input 8");
        System.out.println("If you would like to see an example summary, Input: 9");
        System.out.println("To exit menu, Input: 10");
    }

    public void setUp() {//the bulk of conditional logic sits  here

        int choice = 0; //create a variable of type int to track what the choice of the user is
        boolean isRunning = true; //once the program is running, set a boolean flag to true initially
        System.out.println("***************************");
        System.out.println("Welcome to my Media Database");
        System.out.println("***************************\n");

            //always run the program while the boolean is true
            while (isRunning) {
                boolean validInput = true;
                //call the above method to set up the menu
                setMenu();
                //try some risky code within the try-catch block.
                try {
                    choice = scanner.nextInt(); //scanner will expect an Int
                    scanner.nextLine();
                } catch (InputMismatchException ex) { //If something other than an Int is input, we catch the exception
                    validInput = false; //set the validInput to false so we only progress with a valid input on line 52
                    System.out.println("Error! Invalid input! Ensure Input is a valid choice and try again!\n");
                    scanner.nextLine();
                }
                if (validInput) { //Runs if only a valid input is given, ie. the catch block isnt ran
                    if (choice == 1) {
                        displaySampleMovieLibrary();
                    } else if (choice == 2) {
                        displaySampleTVShowLibrary();
                    } else if (choice == 3) {
                        displaySampleDocumentaryLibrary();
                    } else if (choice == 4) {
                        displayWatchlist();
                    } else if (choice == 5) {
                        addToWatchlist();
                    } else if (choice == 6) {
                        removeFromWatchlist();
                    } else if (choice == 7) {
                        showLog();
                    } else if (choice == 8) {
                        addToLog();
                    } else if (choice == 9) {
                        showSummaryFormat();
                    } else if (choice == 10) {
                        isRunning = false;
                        System.out.println("Thank you!");
                    } else {
                        System.out.println("Number inputted is out of range! Input a correct number!\n");
                    }
                }
            }
    }

    public void displaySampleMovieLibrary() {
        System.out.println("Below is a list of sample movies and accepted formats:");
        System.out.println("*******************************************************");
            //enhanced for loop for moving through the array of sample, for each movie object, we print it out
        ArrayList<Movie> movies = SampleMediaLibrary.getMovies(sampleLibrary);

        for(Movie movie: movies){
            System.out.println(movie);
            System.out.println();
        }

        System.out.println("Total Movies in sample " + Movie.movieCount);

    }

    public void displaySampleTVShowLibrary(){
        System.out.println("Below is a list of sample TV Shows and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<TVShow> TVShows = SampleMediaLibrary.getTVshows(sampleLibrary);

        for (TVShow tv: TVShows){
            System.out.println(tv);
            System.out.println();
        }
    }

    public void displaySampleDocumentaryLibrary(){
        System.out.println("Below is a list of sample Documentaries and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<Documentary> Docs = SampleMediaLibrary.getDocs(sampleLibrary);

        for(Documentary doc: Docs){
            System.out.println(doc);
            System.out.println();
        }
    }

    //call the watchList object method from the WatchList class to print what is in the current watchlist
    public void displayWatchlist() {
        watchList.printList();
    }

    public void showLog(){
        mediaLog.printList();
    }

    public void addToLog() {

        String input;
        System.out.println("Enter what you would like to add to your watched log: (e.g. Gladiator 7.7)");
        input = scanner.nextLine();

        String[] args = input.split(",");

        if (args.length != 2) {
            System.out.println("invalid format, please use: Title, Rating");
            return;
        }
        String title = args[0].trim();
        double rating;

        try {
            rating = Double.parseDouble(args[1].trim());
        } catch (NumberFormatException ex) {
            System.out.println("Rating must be valid number!");
            return;
        }

        try {
            Media media = findMediaInLibrary(title);

            media.setPersonalRating(rating);
            mediaLog.addMedia(media);

            if (watchList.isInList(title)){
                watchList.removeMedia(title);
            }

            System.out.printf("%s added to log with %.2f rating%n", title, rating);

        } catch (InvalidRatingException | DuplicateMediaException | MediaNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addToWatchlist() {
        //create a String to track what is to be added to the watchlist
        String addToWatchlist;
        System.out.println("Enter what you would like adding to the watchlist:");
        addToWatchlist = scanner.nextLine();
        try {
            Media media = findMediaInLibrary(addToWatchlist);
            watchList.addMedia(media);
            System.out.printf("%s added to watchlist", addToWatchlist);
        } catch (MediaNotFoundException | DuplicateMediaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromWatchlist() {
        String removeFromWatchlist;
        System.out.println("Enter what you would like removing from the watchlist:");
        removeFromWatchlist = scanner.nextLine();
        try {
            watchList.removeMedia(removeFromWatchlist);
            System.out.printf("%s removed from watchlist", removeFromWatchlist);
        } catch (MediaNotFoundException ex) {
            System.out.println(ex.getMessage());
            }
    }

    public void showSummaryFormat(){
        System.out.println("Accepted Summary format:");
        for (Media media : sampleLibrary) {
            System.out.println(media.getSummary());
            System.out.println("*******************************************************");
            System.out.println();
        }
    }
}


