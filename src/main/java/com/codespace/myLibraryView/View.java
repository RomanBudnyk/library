package com.codespace.myLibraryView;

public class View {
    public static final String HELLO = "Welcome to the library!";
    public static final String INVITATION = "Choose the point you need: ";
    public static final String ERROR = "WRONG COMMAND!";
    public static final String SUCCESS = "Operation was successful";
    public static final String RESULT = "Here is the result of your command: ";

    public void printMenu() {
        System.out.println("1. Add new book.");
        System.out.println("2. Delete book.");
        System.out.println("3. View all books by the criteria.");
        System.out.println("4. Sort books by the criteria.");
        System.out.println("5. View all the catalog.");
        System.out.println("6. Exit from program.");
    }

    public void printCriteriaForViewing() {
        System.out.println("1. Author.");
        System.out.println("2. Publisher.");
        System.out.println("3. Genre.");
    }

    public void printCriteriaForSorting() {
        System.out.println("1. By author.");
        System.out.println("2. By genre.");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSmallMessage(String message) {
        System.out.print(message);
    }
}
