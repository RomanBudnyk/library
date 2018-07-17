package com.codespace.myLibraryConnector;

public class DeleteBookCommand implements Command {
    LibraryActivities libraryActivities;

    public DeleteBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }


    public void execute() {
        libraryActivities.deleteBook();
    }
}
