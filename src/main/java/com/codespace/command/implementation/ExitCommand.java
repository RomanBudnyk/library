package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ExitCommand implements Command {
    private LibraryActivities libraryActivities;

    public ExitCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.exit();
    }
}
