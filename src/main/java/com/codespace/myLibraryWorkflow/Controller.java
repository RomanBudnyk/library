package com.codespace.myLibraryWorkflow;

import com.codespace.myLibraryConnector.*;
import com.codespace.myLibraryView.View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private LibraryActivities libraryActivities = new LibraryActivities();
    private View view = new View();
    private Invoker invoker = new Invoker(
            new AddNewBookCommand(libraryActivities),
            new DeleteBookCommand(libraryActivities),
            new ViewBooksByAuthorCommand(libraryActivities),
            new ViewBooksByPublisherCommand(libraryActivities),
            new ViewBooksByGenreCommand(libraryActivities),
            new SortBooksByAuthorCommand(libraryActivities),
            new SortBooksByGenreCommand(libraryActivities),
            new ViewAllBooksCommand(libraryActivities),
            new ExitCommand(libraryActivities)
    );

    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        view.printMessage(View.HELLO);
        view.printMessage("\n");
        while (true) {
            view.printMenu();
            int item = inputItem(6);
            view:
            sort:
            switch (item) {

                case 1:
                    view.printMessage(View.RESULT);
                    invoker.add();
                    break;
                case 2:
                    view.printMessage(View.RESULT);
                    invoker.delete();
                    break;
                case 3:
                    view.printCriteriaForViewing();
                    int itemForView = inputItemForSubmenu(3);
                    switch (itemForView) {
                        case 1:
                            view.printMessage(View.RESULT);
                            invoker.viewByAuthor();
                            break view;
                        case 2:
                            view.printMessage(View.RESULT);
                            invoker.viewByPublisher();
                            break view;
                        case 3:
                            view.printMessage(View.RESULT);
                            invoker.viewByGenre();
                            break view;
                    }
                case 4:
                    view.printCriteriaForSorting();
                    int itemForSorting = inputItem(2);
                    switch (itemForSorting) {
                        case 1:
                            view.printMessage(View.RESULT);
                            invoker.sortByAuthor();
                            break sort;
                        case 2:
                            view.printMessage(View.RESULT);
                            invoker.sortByGenre();
                            break sort;
                    }
                case 5:
                    view.printMessage(View.RESULT);
                    invoker.viewAll();
                    break;
                case 6:
                    view.printMessage("Thank you for using our Library. See you next time!");
                    invoker.exit();
            }
            view.printMessage(View.SUCCESS);
            view.printMessage("\n");
        }
    }

    private int inputItem(int a) {
        while (true) {
            view.printMessage(View.INVITATION);
            Scanner scanner = new Scanner(System.in);
            try {
                int item = scanner.nextInt();
                if (item > 0 && item <= a) {
                    return item;
                } else {
                    view.printMessage(View.ERROR);
                    view.printMessage("\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number!");
            }
        }
    }

    private int inputItemForSubmenu(int a) {

        while (true) {
            view.printMessage(View.INVITATION);

            try {
                Scanner scanner = new Scanner(System.in);
                int item = scanner.nextInt();
                if (item > 0 && item <= a) {
                    return item;
                } else {
                    view.printMessage(View.ERROR);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number!");
            }
        }
    }

}
