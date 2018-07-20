package com.codespace.myLibraryWorkflow;

import com.codespace.command.Command;

class Invoker {
    private Command add;
    private Command delete;
    private Command viewByAuthor;
    private Command viewByPublisher;
    private Command viewByGenre;
    private Command sortByAuthor;
    private Command sortByGenre;
    private Command viewAll;
    private Command exit;

    Invoker(Command add, Command delete, Command viewByAuthor, Command viewByPublisher, Command viewByGenre, Command sortByAuthor, Command sortByGenre, Command viewAll, Command exit) {
        this.add = add;
        this.delete = delete;
        this.viewByAuthor = viewByAuthor;
        this.viewByPublisher = viewByPublisher;
        this.viewByGenre = viewByGenre;
        this.sortByAuthor = sortByAuthor;
        this.sortByGenre = sortByGenre;
        this.viewAll = viewAll;
        this.exit = exit;
    }

    void add() {
        add.execute();
    }

    void delete() {
        delete.execute();
    }

    void viewByAuthor() {
        viewByAuthor.execute();
    }

    void viewByPublisher() {
        viewByPublisher.execute();
    }

    void viewByGenre() {
        viewByGenre.execute();
    }

    void sortByAuthor() {
        sortByAuthor.execute();
    }

    void sortByGenre() {
        sortByGenre.execute();
    }

    void viewAll() {
        viewAll.execute();
    }

    void exit() {
        exit.execute();
    }
}
