public class MediaLog extends MediaCollection{

public void rateMedia(String title, double rating) throws InvalidRatingException{
    for (Media media: items){
        if (media.getTitle().equalsIgnoreCase(title)){
            media.setPersonalRating(rating);
            media.markAsSeen();
            break;
        }
    }
}
    @Override
    public void printList() {
        System.out.println("Log of rated Media:");

        for (Media media: items){
            System.out.println(media.getTitle() + " - Rating: " + media.getPersonalRating());
        }
    }
}
