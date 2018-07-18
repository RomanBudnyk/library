package com.codespace.myLibraryConnector;

public class AddNewBookCommand implements Command {
    private LibraryActivities libraryActivities;

    public AddNewBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.addNewBook();
    }
}
