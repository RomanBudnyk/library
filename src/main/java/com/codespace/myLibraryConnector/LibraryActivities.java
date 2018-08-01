package com.codespace.myLibraryConnector;

import com.codespace.myLibraryView.View;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class LibraryActivities {
    private static final Logger logger = Logger.getLogger(LibraryActivities.class);

    private List<Book> bookList = new LinkedList<>();
    private File bookFile = new File("bookcollection.txt");
    private LibraryConsole libraryConsole = new LibraryConsole();
    private View view = new View();

    public void addNewBook() {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        Book book = libraryConsole.addingOfTheBook();
        bookList.add(book);
        writeIntoTheFile(bookList);
        File dir = new File(".\\storage\\");
        if (!dir.exists()) {
            dir.mkdir();
        }
        String nameFile = book.getAuthor() + " - " + book.getName() + " (" + book.getPublisherName() + ", " + book.getYear() + ", " + book.getGenre() + ")";
        try {
            File file = new File(dir, nameFile + ".txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Book created successfully.");
    }

    public void deleteBook() {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        List<Book> tempBook = new LinkedList<>();
        int counter = 0;
        if (!bookList.isEmpty() && bookFile.exists()) {
            view.printSmallMessage("Enter book's name you want to delete: ");
            String bookName = libraryConsole.printing();
            String author;
            for (Book book : bookList) {
                if (book.getName().equals(bookName)) {
                    tempBook.add(book);
                    counter++;
                } else {
                    counter--;
                }
            }
            if (tempBook.size() > 1) {
                view.printSmallMessage("Enter the author name: ");
                author = libraryConsole.printing();
                int counter2 = 0;
                boolean check = false;
                Iterator<Book> iterator = bookList.iterator();
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getAuthor().equals(author) && book.getName().equals(bookName)) {
//                        bookList.remove(book);
                        iterator.remove();
                        writeIntoTheFile(bookList);
                        view.printMessage("Deleted successfully!");
                        logger.info("Deletion of the book successfully.");
                        counter2++;
                        check = true;
                    } else {
                        counter2--;
                    }
                }
                if (counter2 < 0 && !check) {
                    view.printMessage("No book with such author!");
                    logger.info("No such books.");
                }
            } else if (tempBook.size() == 1) {
                Iterator<Book> iterator = bookList.iterator();
                boolean check = false;
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getName().equals(bookName)) {
                        iterator.remove();
                        writeIntoTheFile(bookList);
                        view.printMessage("Deleted successfully!");
                        logger.info("Deletion of the book successfully.");
                        check = true;
                    }
                }
                if (!check) {
                    view.printMessage("No book with such name!");
                    logger.info("No such books.");
                }
            }
            if (counter < 0 && -counter == bookList.size()) {
                view.printMessage("No book with such name!");
                logger.info("No such books.");
            }
        } else {
            view.printMessage("No books in the collection!");
            logger.info("Empty collection.");
        }
    }

//    public void deleteBook() {
//        if (bookFile.exists()) {
//            readFromTheFile();
//        }
//        List<Book> tempBook = new LinkedList<>();
//        int counter = 0;
//        if (!bookList.isEmpty() && bookFile.exists()) {
//            view.printSmallMessage("Enter book's name you want to delete: ");
//            String bookName = libraryConsole.printing();
//            String author;
//            for (Book book : bookList) {
//                if (book.getName().equals(bookName)) {
//                    tempBook.add(book);
//                    counter++;
//                } else {
//                    counter--;
//                }
//            }
//            if (tempBook.size() > 1) {
//                view.printSmallMessage("Enter the author name: ");
//                author = libraryConsole.printing();
//                int counter2 = 0;
//                boolean check = false;
//                List<Book> copy = new LinkedList<>(bookList);
//                for (Book book1 : copy) {
//                    if (book1.getAuthor().equals(author) && book1.getName().equals(bookName)) {
//                        bookList.remove(book1);
//                        writeIntoTheFile(bookList);
//                        view.printMessage("Deleted successfully!");
//                        logger.info("Deletion of the book successfully.");
//                        counter2++;
//                        check = true;
//                    } else {
//                        counter2--;
//                    }
//                }
//                if (counter2 < 0 && !check) {
//                    view.printMessage("No book with such author!");
//                    logger.info("No such books.");
//                }
//            } else if (tempBook.size() == 1) {
//                int counter3 = 0;
//                List<Book> copy = new LinkedList<>(bookList);
//                for (Book book2 : copy) {
//                    if (book2.getName().equals(bookName)) {
//                        bookList.remove(book2);
//                        writeIntoTheFile(bookList);
//                        view.printMessage("Deleted successfully!");
//                        logger.info("Deletion of the book successfully.");
//                    } else {
//                        counter3--;
//                    }
//                }
//                if (counter3 < 0 && -counter3 == copy.size()) {
//                    view.printMessage("No book with such name!");
//                    logger.info("No such books.");
//                }
//            }
//            if (counter < 0 && -counter == bookList.size()) {
//                view.printMessage("No book with such name!");
//                logger.info("No such books.");
//            }
//        } else {
//            view.printMessage("No books in the collection!");
//            logger.info("Empty collection.");
//        }
//    }

    public void viewBooksByAuthor() {
        viewInfoBySetCriteria("author", 1);
    }

    public void viewBooksByPublisher() {
        viewInfoBySetCriteria("publisher", 2);
    }

    public void viewBooksByGenre() {
        viewInfoBySetCriteria("genre", 3);
    }

    public void sortBooksByAuthor() {
        bookList.sort((o1, o2) -> o1.getAuthor().compareToIgnoreCase(o2.getAuthor()));
        writeIntoTheFile(bookList);
        logger.info("Collection sorted by author.");
    }

    public void sortBooksByGenre() {
        bookList.sort((o1, o2) -> o1.getGenre().compareToIgnoreCase(o2.getGenre()));
        writeIntoTheFile(bookList);
        logger.info("Collection sorted by genre.");
    }

    public void viewAllBooks() {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        if (!bookList.isEmpty()) {
            for (Book book : bookList) {
                printBook(book);
            }
            logger.info("Printed all books.");
        } else {
            view.printMessage("Collection is empty!");
            logger.info("Empty collection.");
        }
    }

    public void editBook() {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        if (!bookList.isEmpty()) {
            view.printMessage("Please enter the author and the book name you want to edit.");
            view.printSmallMessage("Enter author: ");
            String authorName = libraryConsole.printing();
            view.printSmallMessage("Enter book name: ");
            String bookName = libraryConsole.printing();
            boolean checkIfEdited = false;
            for (Book book : bookList) {
                if (book.getAuthor().equals(authorName) && book.getName().equals(bookName)) {
                    checkIfEdited = true;
                    System.out.println(book.toString());
                    view.printMessage("Choose attribute you want to edit: ");
                    view.printAttributesOfTheBook();
                    view.printSmallMessage(View.INVITATION);
                    int check = libraryConsole.printingInt();
                    if (check > 0 && check <= 8) {
                        switch (check) {
                            case 1:
                                view.printSmallMessage("Enter new value: ");
                                String initialAuthor = book.getAuthor();
                                book.setAuthor(libraryConsole.printing());
                                view.printMessage("Author of the book " + initialAuthor + " has changed.");
                                logger.info("Author of the book " + initialAuthor + " has changed.");
                                break;
                            case 2:
                                view.printSmallMessage("Enter new value: ");
                                String initialName = book.getName();
                                view.printSmallMessage("Enter new value: ");
                                book.setName(libraryConsole.printing());
                                view.printMessage("Book name of the book " + initialName + " has changed.");
                                logger.info("Book name of the book " + initialName + " has changed.");
                                break;
                            case 3:
                                view.printSmallMessage("Enter new value: ");
                                book.setPublisherName(libraryConsole.printing());
                                view.printMessage("Publisher name of the book " + book.getName() + " has changed.");
                                logger.info("Publisher name of the book " + book.getName() + " has changed.");
                                break;
                            case 4:
                                view.printSmallMessage("Enter new value: ");
                                book.setPublisherYear(libraryConsole.printingInt());
                                view.printMessage("Publisher year of the book " + book.getName() + " has changed.");
                                logger.info("Publisher year of the book " + book.getName() + " has changed.");
                                break;
                            case 5:
                                view.printSmallMessage("Enter new value: ");
                                book.setPublisherCity(libraryConsole.printing());
                                view.printMessage("Publisher year of the book " + book.getName() + " has changed.");
                                logger.info("Publisher year of the book " + book.getName() + " has changed.");
                                break;
                            case 6:
                                view.printSmallMessage("Enter new value: ");
                                book.setYear(libraryConsole.printingInt());
                                view.printMessage("Year of the book " + book.getName() + " has changed.");
                                logger.info("Year of the book " + book.getName() + " has changed.");
                                break;
                            case 7:
                                view.printSmallMessage("Enter new value: ");
                                book.setPages(libraryConsole.printingInt());
                                view.printMessage("Pages of the book " + book.getName() + " has changed.");
                                logger.info("Pages of the book " + book.getName() + " has changed.");
                                break;
                            case 8:
                                view.printSmallMessage("Enter new value: ");
                                book.setGenre(libraryConsole.printing());
                                view.printMessage("Genre of the book " + book.getName() + " has changed.");
                                logger.info("Genre of the book " + book.getName() + " has changed.");
                                break;
                        }
                    }
                }
            }
            if (!checkIfEdited) {
                view.printMessage("Such a book was not found.");
                logger.info("No book has found during editing of the book.");
            }
        } else {
            view.printMessage("Collection is empty!");
            logger.info("Empty collection.");
        }
        writeIntoTheFile(bookList);
    }

    public void readBook() {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        if (!bookList.isEmpty()) {
            view.printMessage("Please enter the author and the book name you want to edit.");
            view.printSmallMessage("Enter author: ");
            String authorName = libraryConsole.printing();
            view.printSmallMessage("Enter book name: ");
            String bookName = libraryConsole.printing();


        } else {
            view.printMessage("Collection is empty!");
            logger.info("Empty collection.");
        }

    }

    public void exit() {
        logger.info("Exit from the program.");
        System.exit(0);
    }

    private void printBook(Book book) {
        System.out.println(book.toString());
    }

    private void viewInfoBySetCriteria(String string, int check) {
        if (bookFile.exists()) {
            readFromTheFile();
        }
        if (!bookList.isEmpty() && bookFile.exists()) {
            view.printSmallMessage("Enter " + string + "'s name who's books you want to be displayed: ");
            String stringField = libraryConsole.printing();
            int counter = 0;
            for (Book book : bookList) {
                boolean checking = false;
                switch (check) {
                    case 1:
                        checking = book.getAuthor().equals(stringField);
                        break;
                    case 2:
                        checking = book.getPublisherName().equals(stringField);
                        break;
                    case 3:
                        checking = book.getGenre().equals(stringField);
                }
                if (checking) {
                    printBook(book);
                    counter++;
                    logger.info("Match in " + string + " found.");
                } else {
                    counter--;
                }
            }
            if (counter < 0 && -counter == bookList.size()) {
                view.printMessage("No books with such " + string + "!");
                logger.info("No books with such " + string + ".");
            }
        } else {
            view.printMessage("No books in the collection!");
            logger.info("Empty collection.");
        }
    }

    private void writeIntoTheFile(List<Book> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(bookFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(list);
            logger.info("Collection has been written into file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void readFromTheFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(bookFile))) {
            bookList = (List<Book>) objectInputStream.readObject();
            logger.info("Reading from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
}
