package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class SortBooksByGenreCommand implements Command {
    private LibraryActivities libraryActivities;

    public SortBooksByGenreCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.sortBooksByGenre();
    }
}


