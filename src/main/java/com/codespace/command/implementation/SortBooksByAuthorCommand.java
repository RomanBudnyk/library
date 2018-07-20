package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class SortBooksByAuthorCommand implements Command {
    private LibraryActivities libraryActivities;

    public SortBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.sortBooksByAuthor();
    }
}
