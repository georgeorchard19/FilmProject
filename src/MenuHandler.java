import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuHandler {

    //TODO Add way to sort watchlist by year, alphabetically, group by genre, etc - COMPARATOR GENERICS
    protected Scanner scanner;
    protected WatchList watchList;
    protected ArrayList<Media> sampleLibrary;
    protected MediaLog mediaLog;

    public MenuHandler() { //Constructor once called will create the 3 objects below without needing to pass in any parameters
        this.scanner = new Scanner(System.in); // creates it itself
        this.watchList = new WatchList();      // creates it itself
        this.sampleLibrary = SampleMediaLibrary.setSampleLibrary();
        this.mediaLog = new MediaLog();

        System.out.println("***************************");
        System.out.println("Welcome to my Media Project");
        System.out.println("***************************\n");
    }

    protected String promptUser(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public void setMenu(){ //creates the initial menu design in the console
        System.out.println("1 - View Sample Media");
        System.out.println("2 - WatchList");
        System.out.println("3 - LoggedMedia");
        System.out.println("4 - EXIT");
    }

    public void setUp() {//the bulk of conditional logic sits  here

        boolean isRunning = true; //once the program is running, set a boolean flag to true initially

            //always run the program while the boolean is true
            while (isRunning) {
                //call the above method to set up the menu
                setMenu();
                //try some risky code within the try-catch block.
                try {
                    int choice = scanner.nextInt(); //scanner will expect an Int
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> {
                            SampleLibraryMenuHandler sampleLibraryMenu = new SampleLibraryMenuHandler(sampleLibrary);
                            sampleLibraryMenu.setUp();
                        }
                        case 2 -> {
                            WatchListMenuHandler watchListMenu = new WatchListMenuHandler(watchList);
                            watchListMenu.setUp();
                        }
                        case 3 -> {
                            MediaLogMenuHandler logMenu = new MediaLogMenuHandler(mediaLog, watchList);
                            logMenu.setUp();
                        }
                        case 4 -> {
                            isRunning = false;
                            System.out.println("Thank you!");
                        }
                        default -> System.out.println("Number inputted is out of range! Input a correct number!\n");
                    }
                } catch (InputMismatchException ex) { //If something other than an Int is input, we catch the exception
                    //set the validInput to false so we only progress with a valid input on line 52
                    System.out.println("Error! Invalid input! Ensure Input is a valid choice and try again!\n");
                    scanner.nextLine();
                }
            }

    }

    protected Media findMediaInLibrary(String title) throws MediaNotFoundException{
        for (Media media: sampleLibrary){
            if(media.getTitle().equalsIgnoreCase(title)){
                return media;
            }
        }
        throw new MediaNotFoundException("'" + title + "' Not in sample library!");
    }
}


