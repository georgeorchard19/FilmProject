import java.util.ArrayList;

public class WatchList {

    private ArrayList<Media> watchList = new ArrayList<>();


    public ArrayList<Media> getWatchList() {
        return this.watchList;
    }

    public void addMedia(Media media) {
        if (isInWatchList(media.getTitle())) {
            System.out.println(String.format("%s is already in watchlist.", media.getTitle()));
        } else {
            watchList.add(media);
        }
    }

    public void removeMedia(String title) {
        for (int i = 0; i < watchList.size(); i++) {
            if (watchList.get(i).getTitle().equalsIgnoreCase(title)) {
                watchList.remove(i);
                break;
            }
        }
    }

    public boolean isInWatchList(String title) {
        for (Media media : watchList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    public void markAsSeen (String title){
        for (Media media : watchList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                media.markAsSeen();
            }
        }
            if (!isInWatchList(title)) {
                System.out.println("Not in watchlist, cannot be marked as seen!");
            }

    }

    public void printWatchlist() {

        if (watchList.isEmpty()){
            System.out.println("NOTHING IN WATCHLIST");
        }
        else {
            System.out.println("******************");
            System.out.println("Current Watchlist:");
            for (Media media : watchList) {
                System.out.println(media.getTitle());
            }
        }
    }
}



