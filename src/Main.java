import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main (String[]args) {

            Scanner scanner = new Scanner(System.in);
            WatchList watchlist = new WatchList();
            MediaLog mediaLog = new MediaLog();
            ArrayList<Media> library = SampleMediaLibrary.setSampleLibrary();


            MenuHandler menu = new MenuHandler(scanner, watchlist, library, mediaLog);
            menu.setUp();
        }

}