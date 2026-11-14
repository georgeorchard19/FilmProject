# filmProject

A command-line app for browsing a library of films, TV shows and documentaries, keeping a watchlist, and logging what you've watched with your own ratings.

I'm building it to learn Java and object-oriented design, so it's a learning project rather than a finished product.

## Features

- **Browse the sample library.** List the movies, TV shows or documentaries, or search by title (partial and case-insensitive).
- **Watchlist.** Add things you want to watch, view the list, and remove items.
- **Watch log.** Log what you've watched with a personal rating, sort the log by title, and see your average rating.

The watchlist and log are kept in memory, so they're cleared when the app closes.

## Requirements

- Java 26 (JDK)
- Maven

## Running it

```bash
git clone https://github.com/georgeorchard19/filmProject.git
cd filmProject
mvn compile
java -cp target/classes com.georgeorchard.filmproject.Application
```

You can also open the project in IntelliJ IDEA and run `Application`.

## Project structure

```
src/main/java/com/georgeorchard/filmproject/
├── Application.java   entry point
├── model/             Media (abstract) and its subclasses Movie, TVShow, Documentary
├── collection/        MediaCollection (abstract), WatchList, MediaLog
├── menu/              Menu (abstract) and the console menus that extend it
├── source/            SampleMediaLibrary: the built-in sample data
└── exception/         custom exceptions
```

## What it demonstrates

- **Encapsulation:** private fields with getters, and validation in setters
- **Inheritance and abstract classes:** `Media`, `MediaCollection` and `Menu`
- **Polymorphism:** each media type provides its own summary and details
- **Template Method pattern:** `Menu` runs the shared menu loop, and each menu supplies its own options
- **Custom exceptions:** for duplicates, missing media and invalid ratings
- **Streams and lambdas:** filtering and searching the library

## Planned

- Unit tests and CI on every pull request
- Search by genre and director
- Saving the watchlist and log to a database
- Pulling real film data from a movie API
- A Spring Boot REST API front end
