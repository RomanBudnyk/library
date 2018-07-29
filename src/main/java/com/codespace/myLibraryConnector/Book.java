package com.codespace.myLibraryConnector;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String author;
    private String name;
    private String publisherName;
    private int publisherYear;
    private String publisherCity;
    private int year;
    private int pages;
    private String genre;

    public Book(String author, String name, String publisherName, int publisherYear, String publisherCity, int year, int pages, String genre) {
        this.author = author;
        this.name = name;
        this.publisherName = publisherName;
        this.publisherYear = publisherYear;
        this.publisherCity = publisherCity;
        this.year = year;
        this.pages = pages;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public int getPublisherYear() {
        return publisherYear;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return "Author's name: " + author + "; " +
                "Book's name: " + name + "; " +
                "Publisher's name: " + publisherName + "; " +
                "Publisher's year: " + publisherYear + "; " +
                "Publisher's city: " + publisherCity + "; " +
                "Year of publish: " + year + "; " +
                "Pages in book: " + pages + "; " +
                "Book's genre: " + genre + "; ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publisherYear == book.publisherYear &&
                year == book.year &&
                pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(name, book.name) &&
                Objects.equals(publisherName, book.publisherName) &&
                Objects.equals(publisherCity, book.publisherCity) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, name, publisherName, publisherYear, publisherCity, year, pages, genre);
    }
}
