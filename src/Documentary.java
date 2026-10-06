public class Documentary extends Media{

    private final String TOPIC;
    private final String NARRATOR;

    public Documentary(String title, int year, String genre, double rating, String topic, String narrator) {
        super(title, year, genre, rating);
        this.TOPIC = topic;
        this.NARRATOR = narrator;
    }

    public String getTopic(){
        return this.TOPIC;
    }

    public String getNarrator(){
        return this.NARRATOR;
    }


    @Override
    public String toString(){
        return String.format("%s (%d) | %s | Narrator: %s | %s | %.1f/10",
                getTitle(), getYear(), getGenre(), NARRATOR, TOPIC, getRating());
    }

    @Override
    public String getSummary(){
        return String.format("%s | %s | %s | %.1f/10", getTitle(), NARRATOR, TOPIC, getRating());
    }


}
