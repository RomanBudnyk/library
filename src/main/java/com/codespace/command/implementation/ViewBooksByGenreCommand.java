package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ViewBooksByGenreCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewBooksByGenreCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByGenre();
    }
}
