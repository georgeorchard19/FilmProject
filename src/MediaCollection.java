import java.util.ArrayList;

public abstract class MediaCollection {

        protected ArrayList<Media> items = new ArrayList<>();

        public void addMedia(Media media) {
            if (isInList(media.getTitle())) {
                System.out.println(String.format("%s is already in collection.", media.getTitle()));
            } else {
                items.add(media);
            }
        }

        public void removeMedia(String title) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getTitle().equalsIgnoreCase(title)) {
                    items.remove(i);
                    break;
                }
            }
        }

        public boolean isInList(String title) {
            for (Media media : items) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    return true;
                }
            }
            return false;
        }

        public void markAsSeen(String title) {
            for (Media media : items) {
                if (media.getTitle().equalsIgnoreCase(title)) {
                    media.markAsSeen();
                    break;
                }
            }
            if (!isInList(title)) {
                System.out.println("Not in collection, cannot be marked as seen!");
            }

        }

        public abstract void printList();


    }

