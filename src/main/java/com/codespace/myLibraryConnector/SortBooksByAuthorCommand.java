package com.codespace.myLibraryConnector;

public class SortBooksByAuthorCommand implements Command {
    private LibraryActivities libraryActivities;

    public SortBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.sortBooksByAuthor();
    }
}
