package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ReadBookFromFileCommand implements Command {

    private LibraryActivities libraryActivities;

    public ReadBookFromFileCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    @Override
    public void execute() {
        libraryActivities.readBook();
    }
}
