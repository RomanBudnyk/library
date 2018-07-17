package com.codespace.myLibraryConnector;

public class ViewBooksByAuthorCommand implements Command {
    LibraryActivities libraryActivities;

    public ViewBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByAuthor();
    }
}
