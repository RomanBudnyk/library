package com.codespace.myLibraryConnector;

public class ViewAllBooksCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewAllBooksCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewAllBooks();
    }
}
