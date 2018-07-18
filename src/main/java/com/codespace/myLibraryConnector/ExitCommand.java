package com.codespace.myLibraryConnector;

public class ExitCommand implements Command{
    private LibraryActivities libraryActivities;

    public ExitCommand(LibraryActivities libraryActivities) {
        this.libraryActivities = libraryActivities;
    }

    public void execute() {
        libraryActivities.exit();
    }
}
