package com.codespace.myLibraryConnector;

public class ViewBooksByPublisherCommand implements Command{
    LibraryActivities libraryActivities;


    public ViewBooksByPublisherCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.viewBooksByPublisher();
    }
}
