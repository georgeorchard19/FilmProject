public class TVShow extends Media {

    private final int totalEpisodes;
    private final int totalSeasons;
    private final String plot;
    private final String network;
    private final int emmys;

    public TVShow(String title, int year, String genre, double rating, int totalEpisodes, int totalSeasons,
                  String plot, String network, int emmys){
        super(title, year, genre, rating);
        this.totalEpisodes = totalEpisodes;
        this.totalSeasons = totalSeasons;
        this.plot = plot;
        this.emmys = emmys;
        this.network = network;
    }

    public int getTotalEpisodes(){
        return this.totalEpisodes;
    }
    public int getTotalSeasons(){
        return this.totalSeasons;
    }
    public String getPlot(){
        return this.plot;
    }
    public String getNetwork(){
        return this.network;
    }
    public int getEmmys(){
        return this.emmys;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Total episodes: %d | Total Seasons: %d | Streaming on: %s | %.1f/10\nPLOT: %s",
                getTitle(), getGenre(), totalEpisodes, totalSeasons, network, getRating(), plot);
    }

    public String getSummary(){
        return String.format("%s | %s | %s | %.1f/10", getTitle(), getGenre(), getRating());
    }
}
