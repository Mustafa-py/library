package com.example.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int publication_year;
    private String isbn; //Международный стандартный номер книги

    public Book() {
    }

    public Book(String title, String author, int publication_year, String isbn) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.isbn = isbn;
    }

    public Book(Long id, String title, String author, int publication_year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.isbn = isbn;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublication_year() {
        return this.publication_year;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Book)) return false;
        final Book other = (Book) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$author = this.getAuthor();
        final Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) return false;
        if (this.getPublication_year() != other.getPublication_year()) return false;
        final Object this$isbn = this.getIsbn();
        final Object other$isbn = other.getIsbn();
        if (this$isbn == null ? other$isbn != null : !this$isbn.equals(other$isbn)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Book;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $author = this.getAuthor();
        result = result * PRIME + ($author == null ? 43 : $author.hashCode());
        result = result * PRIME + this.getPublication_year();
        final Object $isbn = this.getIsbn();
        result = result * PRIME + ($isbn == null ? 43 : $isbn.hashCode());
        return result;
    }

    public String toString() {
        return "Book(id=" + this.getId() + ", title=" + this.getTitle() + ", author=" + this.getAuthor() + ", publication_year=" + this.getPublication_year() + ", isbn=" + this.getIsbn() + ")";
    }
}
