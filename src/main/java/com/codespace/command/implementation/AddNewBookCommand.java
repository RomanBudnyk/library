package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class AddNewBookCommand implements Command {
    private LibraryActivities libraryActivities;

    public AddNewBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.addNewBook();
    }
}
