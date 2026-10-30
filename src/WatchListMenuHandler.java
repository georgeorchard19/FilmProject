import java.util.Scanner;

public class WatchListMenuHandler extends MenuHandler{

public WatchListMenuHandler(WatchList watchList, Scanner scanner){
    this.watchList = watchList;
    this.scanner = scanner;
}

@Override
public void setMenu(){
    System.out.println("\n--- Watch List Options ---");
    System.out.println("1 - View Watchlist");
    System.out.println("2 - Add to Watchlist");
    System.out.println("3 - Remove from Watchlist");
    System.out.println("4 - Exit Menu");

}

@Override
    public void setUp(){

        boolean inMenu = true;

        while (inMenu){

            setMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> displayWatchlist();
                case 2 -> addToWatchlist();
                case 3 -> removeFromWatchlist();
                case 4 -> inMenu = false;
            }
        }
    }

    //call the watchList object method from the WatchList class to print what is in the current watchlist
    private void displayWatchlist() {
        watchList.printList();
    }


    private void addToWatchlist() {
        //create a String to track what is to be added to the watchlist
        String addToWatchlist = promptUser("Enter what you would like adding to the watchlist:");
        try {
            Media media = SampleMediaLibrary.findMediaInLibrary(addToWatchlist, sampleLibrary);
            watchList.addMedia(media);
            System.out.printf("%s added to watchlist", addToWatchlist);
        } catch (MediaNotFoundException | DuplicateMediaException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeFromWatchlist() {

        String removeFromWatchlist = promptUser("Enter what you would like removing from the watchlist:");

        try {
            watchList.removeMedia(removeFromWatchlist);
            System.out.printf("%s removed from watchlist", removeFromWatchlist);
        } catch (MediaNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
