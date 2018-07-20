package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class DeleteBookCommand implements Command {
    private LibraryActivities libraryActivities;

    public DeleteBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.deleteBook();
    }
}
