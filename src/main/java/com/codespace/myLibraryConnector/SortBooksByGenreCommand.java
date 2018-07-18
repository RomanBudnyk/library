package com.codespace.myLibraryConnector;

public class SortBooksByGenreCommand implements Command {
    private LibraryActivities libraryActivities;

    public SortBooksByGenreCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.sortBooksByGenre();
    }
}


