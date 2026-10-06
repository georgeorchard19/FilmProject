import java.util.ArrayList;
import java.util.Arrays;

public class SampleMediaLibrary {

    public static ArrayList<Media> setSampleLibrary() {

        Media usualSuspects = new Movie("The Usual Suspects",
                1993, "Mystery", "Kevin Spacey, Benicio Del Toro",
                "Thief job gone wrong", "Bryan Singer", 3, 9.3);

        Media gladiator = new Movie("Gladiator",
                2000, "Historical", "Russel Crowe, Joaquin Phoenix",
                "Revenge in Rome", "Ridley Scott", 1, 9.6);

        Media shawshankRedemption = new Movie("The Shawshank Redemption",
                1994, "Drama", "Tim Robbins, Morgan Freeman",
                "Hope inside a tough prison", "Frank Darabont", 5, 9.3);

        Media godfather = new Movie("The Godfather",
                1972, "Crime", "Marlon Brando, Al Pacino",
                "A mafia family dynasty", "Francis Ford Coppola", 5, 9.2);

        Media darkKnight = new Movie("The Dark Knight",
                2008, "Action", "Christian Bale, Heath Ledger",
                "Batman fights the Joker", "Christopher Nolan", 5, 9.0);

        Media pulpFiction = new Movie("Pulp Fiction",
                1994, "Crime", "John Travolta, Samuel L. Jackson",
                "Interwoven LA crime tales", "Quentin Tarantino", 4, 8.9);

        Media inception = new Movie("Inception",
                2010, "Sci-Fi", "Leonardo DiCaprio, Joseph Gordon-Levitt",
                "Stealing secrets inside dreams", "Christopher Nolan", 5, 8.8);

        Media matrix = new Movie("The Matrix",
                1999, "Sci-Fi", "Keanu Reeves, Laurence Fishburne",
                "Discovering simulated reality", "Lana Wachowski, Lilly Wachowski", 4, 8.7);

        Media goodfellas = new Movie("Goodfellas",
                1990, "Crime", "Robert De Niro, Ray Liotta",
                "Rise and fall of a mobster", "Martin Scorsese", 4, 8.7);

        Media fightClub = new Movie("Fight Club",
                1999, "Drama", "Brad Pitt, Edward Norton",
                "An underground club spirals out of control", "David Fincher", 4, 8.8);

        Media silenceOfTheLambs = new Movie("The Silence of the Lambs",
                1991, "Thriller", "Jodie Foster, Anthony Hopkins",
                "FBI agent consults an imprisoned killer", "Jonathan Demme", 5, 8.6);

        Media interstellar = new Movie("Interstellar",
                2014, "Sci-Fi", "Matthew McConaughey, Anne Hathaway",
                "A space mission to save humanity", "Christopher Nolan", 5, 8.7);

        Media jurassicPark = new Movie("Jurassic Park",
                1993, "Adventure", "Sam Neill, Laura Dern",
                "Cloned dinosaurs break loose in a park", "Steven Spielberg", 4, 8.2);

        Media alien = new Movie("Alien",
                1979, "Sci-Fi", "Sigourney Weaver, Tom Skerritt",
                "A space crew encounters a deadly creature", "Ridley Scott", 4, 8.5);

        Media whiplash = new Movie("Whiplash",
                2014, "Drama", "Miles Teller, J.K. Simmons",
                "A ambitious drummer faces an abusive instructor", "Damien Chazelle", 5, 8.5);

        Media prestige = new Movie("The Prestige",
                2006, "Mystery", "Christian Bale, Hugh Jackman",
                "Rival magicians obsess over the ultimate trick", "Christopher Nolan", 4, 8.5);

        Media planetEarth = new Documentary(
                "Planet Earth II", 2016, "Nature", 9.5,
                "Nature & Wildlife", "David Attenborough");

        Media lastDance = new Documentary(
                "The Last Dance", 2020, "Sports", 9.1,
                "1990s Chicago Bulls Dynasty", "Michael Jordan / Phil Jackson");

        Media myOctopusTeacher = new Documentary(
                "My Octopus Teacher", 2020, "Nature", 8.1,
                "Marine Biology & Inter-species Connection", "Craig Foster");

        Media freeSolo = new Documentary(
                "Free Solo", 2018, "Sports", 8.1,
                "Free Solo Rock Climbing", "Alex Honnold");

        Media socialDilemma = new Documentary(
                "The Social Dilemma", 2020, "Technology", 7.6,
                "Impact of Social Networking on Society", "Tristan Harris & Experts");

        Media breakingBad = new TVShow(
                "Breaking Bad", 2008, "Crime Drama", 9.5,
                62, 5, "A high school chemistry teacher turned drug lord",
                "AMC", 16);

        Media theOffice = new TVShow(
                "The Office", 2005, "Comedy", 8.9,
                201, 9, "A mockumentary on a group of office workers",
                "NBC", 5);

        Media gameOfThrones = new TVShow(
                "Game of Thrones", 2011, "Fantasy", 9.2,
                73, 8, "Nine noble families fight for control over Westeros",
                "HBO", 59);

        Media strangerThings = new TVShow(
                "Stranger Things", 2016, "Sci-Fi", 8.7,
                34, 4, "A town uncovers a mystery involving secret experiments",
                "Netflix", 12);

        Media succession = new TVShow(
                "Succession", 2018, "Drama", 8.9,
                39, 4, "A media family fights for control of their empire",
                "HBO", 19);

        Media sherlock = new TVShow(
                "Sherlock", 2010, "Mystery", 9.1,
                13, 4, "A modern update to the famous detective stories",
                "BBC", 9);


        Media[] mediaArray = {usualSuspects, gladiator, shawshankRedemption, godfather, darkKnight,
                pulpFiction, inception, interstellar, matrix, goodfellas, fightClub, silenceOfTheLambs, jurassicPark,
                alien, whiplash, prestige, breakingBad, theOffice, gameOfThrones, strangerThings, succession, sherlock,
                planetEarth, lastDance, myOctopusTeacher, freeSolo, socialDilemma};

        return new ArrayList<>(Arrays.asList(mediaArray));
    }

    public static ArrayList<Movie> getMovies(ArrayList<Media> sampleLibrary) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (Media media : sampleLibrary) {
            if (media instanceof Movie movie) {
                movies.add(movie);
            }
        }
        return movies;

    }

    public static ArrayList<TVShow> getTVshows(ArrayList<Media> sampleLibrary){
        ArrayList<TVShow> shows = new ArrayList<>();

        for(Media media: sampleLibrary){
            if(media instanceof TVShow show){
                shows.add(show);
            }
        }
        return shows;
    }


    public static ArrayList<Documentary> getDocs(ArrayList<Media> sampleLibrary){
        ArrayList<Documentary> docs = new ArrayList<>();

        for (Media media: sampleLibrary){
            if(media instanceof Documentary doc){
                docs.add(doc);
            }
        }

        return docs;
    }

}

