import java.util.ArrayList;

public class SampleLibraryMenuHandler extends MenuHandler{

    public SampleLibraryMenuHandler(ArrayList<Media> sampleMediaLibrary){
        this.sampleLibrary = sampleMediaLibrary;
    }

    @Override
    public void setMenu(){
        System.out.println("\n--- Sample Library Options ---");
        System.out.println("1 - List of sample Movies");
        System.out.println("2 - List of sample TV shows");
        System.out.println("3 - List of sample Documentaries");
        System.out.println("4 - Exit Menu");
    }

    @Override
    public void setUp(){

        boolean inMenu = true;

        while (inMenu){

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> displaySampleMovieLibrary();
                case 2 -> displaySampleTVShowLibrary();
                case 3 -> displaySampleDocumentaryLibrary();
                case 4 -> inMenu = false;
            }
        }
    }

    private void displaySampleMovieLibrary() {
        System.out.println("Below is a list of sample movies and accepted formats:");
        System.out.println("*******************************************************");
        //enhanced for loop for moving through the array of sample, for each movie object, we print it out
        ArrayList<Movie> movies = SampleMediaLibrary.getMovies(sampleLibrary);

        for(Movie movie: movies){
            System.out.println(movie);
            System.out.println();
        }

        System.out.println("Total Movies in sample " + Movie.movieCount);

    }

    private void displaySampleTVShowLibrary(){
        System.out.println("Below is a list of sample TV Shows and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<TVShow> TVShows = SampleMediaLibrary.getTVshows(sampleLibrary);

        for (TVShow tv: TVShows){
            System.out.println(tv);
            System.out.println();
        }
    }

    private void displaySampleDocumentaryLibrary(){
        System.out.println("Below is a list of sample Documentaries and accepted formats:");
        System.out.println("*******************************************************");

        ArrayList<Documentary> Docs = SampleMediaLibrary.getDocs(sampleLibrary);

        for(Documentary doc: Docs){
            System.out.println(doc);
            System.out.println();
        }
    }
}
