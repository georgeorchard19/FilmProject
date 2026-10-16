public class WatchList extends MediaCollection {

    @Override
    public void printList() {

        if (items.isEmpty()){
            System.out.println("NOTHING IN WATCHLIST");
        }
        else {
            System.out.println("******************");
            System.out.println("Current Watchlist:");
            for (Media media : items) {
                System.out.println(media.getTitle());
            }
        }
    }
}



