package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class EditBookCommand implements Command {
    private LibraryActivities libraryActivities;

    public EditBookCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    @Override
    public void execute() {
        libraryActivities.editBook();
    }
}
