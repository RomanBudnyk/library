package com.codespace.myLibraryConnector;

public class ViewBooksByAuthorCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByAuthor();
    }
}
