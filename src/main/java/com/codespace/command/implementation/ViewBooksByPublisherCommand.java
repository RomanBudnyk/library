package com.codespace.command.implementation;

import com.codespace.command.Command;
import com.codespace.myLibraryConnector.LibraryActivities;

public class ViewBooksByPublisherCommand implements Command {
    private LibraryActivities libraryActivities;

    public ViewBooksByPublisherCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByPublisher();
    }
}
