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


public double getAverageRating() {

    double sum = 0.0;

    if (items.isEmpty()){
        return 0.0;
    }

    for (Media media: items){

        sum += media.getRating();
    }

    return sum/items.size();

}


    @Override
    public void printList() {
        System.out.println("Log of rated Media:");

        for (Media media: items){
            System.out.println(media.getTitle() + " - Rating: " + media.getPersonalRating());
        }
    }
}
