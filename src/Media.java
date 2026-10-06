public abstract class Media {

    private final String title; // final as cannot be changed
    private final int year;
    private final String genre;
    private double rating; // not final as can change over time via API
    private double personalRating;
    private boolean seen;

    public Media (String title, int year, String genre, double rating){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle(){
        return this.title;
    }
    public int getYear(){
        return this.year;
    }
    public String getGenre(){
        return this.genre;
    }
    public double getRating(){
        return this.rating;
    }

    public void setPersonalRating(double personalRating) throws InvalidRatingException { //sets rating to whatever is passed in
        if (personalRating < 0.0 || personalRating > 10.0){
            throw new InvalidRatingException("Invalid Rating!");
        }
        else {
            this.personalRating = personalRating;
        }
    }

    public double getPersonalRating(){ //sets rating to whatever is passed in
        return personalRating;
    }

    public void markAsSeen() {
        seen = true;
    }

    public boolean isSeen() {
        return seen;
    }

    public abstract String getSummary();
}
