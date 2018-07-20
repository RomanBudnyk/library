package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ViewAllBooksCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewAllBooksCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewAllBooks();
    }
}
