import java.util.Collection;
import java.util.Collections;

public class MediaLogMenuHandler extends MenuHandler {

   public MediaLogMenuHandler(MediaLog mediaLog, WatchList watchList) {
        this.mediaLog = mediaLog;
        this.watchList = watchList;
    }

    @Override
    public void setMenu() {
        System.out.println("\n--- Watch Log Options ---");
        System.out.println("1 - View current log");
        System.out.println("2 - Add to watch-log");
        System.out.println("3 - Add to watch-log");

        System.out.println("4 - Exit Menu");
    }

    @Override
    public void setUp() {
        //create a variable of type int to track what the choice of the user is
        boolean inMenu = true;

        while(inMenu){
            setMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> showLog();
                case 2 -> addToLog();
                case 3 -> Collections.sort(mediaLog);
                case 4 -> inMenu = false;
            }
        }
    }

    public void showLog(){
        mediaLog.printList();
    }

    public void addToLog() {

        String input = promptUser("Enter what you would like to add to your watched log: (e.g. Gladiator 7.7)");

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
}
