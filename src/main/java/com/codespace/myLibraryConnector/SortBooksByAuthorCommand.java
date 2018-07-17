package com.codespace.myLibraryConnector;

public class SortBooksByAuthorCommand implements Command {
    LibraryActivities libraryActivities;

    public SortBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.sortBooksByAuthor();
    }
}
