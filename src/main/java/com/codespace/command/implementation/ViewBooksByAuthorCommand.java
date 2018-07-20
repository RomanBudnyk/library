package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ViewBooksByAuthorCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewBooksByAuthorCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByAuthor();
    }
}
