package com.codespace.myLibraryConnector;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class LibraryConsole {
    private static final Logger logger = Logger.getLogger(LibraryActivities.class);

    Book addingOfTheBook() {
        System.out.print("Enter author's name: ");
        String author = validationString("Author ");
        System.out.print("Enter book's name: ");
        String bookName = validationString("Name of the book ");
        System.out.print("Enter publisher's name: ");
        String publisherName = validationString("Name of the publisher ");
        System.out.print("Enter publisher's year of creation: ");
        int yearOfPublisher = validationInt("Year of publisher creation ");
        System.out.print("Enter publisher's city: ");
        String publisherCity = validationString("City of the publisher ");
        System.out.print("Enter book's year: ");
        int yearOfBook = validationInt("Year of book release ");
        System.out.print("Enter book's pages: ");
        int pages = validationInt("Count of book's pages ");
        System.out.print("Enter book's genre: ");
        String genre = validationString("Genre ");
        return new Book(author, bookName, publisherName, yearOfPublisher, publisherCity, yearOfBook, pages, genre);
    }

    String printing() {
        String resultOfPrinting;
        do {
            Scanner scanner = new Scanner(System.in);
            resultOfPrinting = scanner.nextLine();
            if (resultOfPrinting.equals("")) {
                System.out.print("Empty input!");
                logger.error("Empty string");
            }
        } while (resultOfPrinting.equals(""));
        return resultOfPrinting;
    }

    int printingInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String validationString(String name) {
        String field;
        do {
            Scanner scanner = new Scanner(System.in);
            field = scanner.nextLine();
            if (field.equals("")) {
                System.out.print(name + "could not be empty! Please enter valid value: ");
                logger.error("Empty string");
            }
        } while (field.equals(""));
        return field;
    }

    private int validationInt(String name) {
        int field = 0;
        do {
            try {
                Scanner scannerInt = new Scanner(System.in);
                field = scannerInt.nextInt();
//                if (field == 0) {
//                    System.out.println(name + "could not be empty! Please enter valid value: ");
//                }
            } catch (InputMismatchException e) {
                System.out.print("Wrong input! Please enter valid year of creation of the publisher: ");
            } catch (NoSuchElementException e) {
                System.out.println(name + "could not be empty! Please enter valid value: ");
            }
        } while (field == 0);
        return field;
    }
}
