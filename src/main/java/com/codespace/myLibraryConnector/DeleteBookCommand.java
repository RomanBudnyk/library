package com.codespace.myLibraryConnector;

public class DeleteBookCommand implements Command {
    private LibraryActivities libraryActivities;

    public DeleteBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.deleteBook();
    }
}
