package com.codespace.myLibraryConnector;

public class ViewBooksByGenreCommand implements Command{
    private LibraryActivities libraryActivities;

    public ViewBooksByGenreCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByGenre();
    }
}
