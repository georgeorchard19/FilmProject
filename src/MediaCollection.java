import java.util.ArrayList;
import java.util.Collections;

public abstract class MediaCollection {

        protected ArrayList<Media> items = new ArrayList<>();

        public void addMedia(Media media) throws DuplicateMediaException {
            if (isInList(media.getTitle())) {
                throw new DuplicateMediaException(media.getTitle() + " is already in collection.");
            } else {
                items.add(media);
            }
        }

        public void removeMedia(String title) throws MediaNotFoundException {
            if (!isInList(title)) {
                throw new MediaNotFoundException("'" + title + "' is not in the collection.");
            }

            // If it is in the list, perform the actual removal here:
            items.removeIf(media -> media.getTitle().equalsIgnoreCase(title));

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

        public void sortByTitle(){
            Collections.sort(items);
        }
    }

