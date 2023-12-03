package com.example.library.models;

import jakarta.persistence.*;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long copyId;

    @ManyToOne
    private Book book;

    private boolean available;

    public BookCopy() {
    }

    public Long getCopyId() {
        return this.copyId;
    }

    public Book getBook() {
        return this.book;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BookCopy)) return false;
        final BookCopy other = (BookCopy) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$copyId = this.getCopyId();
        final Object other$copyId = other.getCopyId();
        if (this$copyId == null ? other$copyId != null : !this$copyId.equals(other$copyId)) return false;
        final Object this$book = this.getBook();
        final Object other$book = other.getBook();
        if (this$book == null ? other$book != null : !this$book.equals(other$book)) return false;
        if (this.isAvailable() != other.isAvailable()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BookCopy;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $copyId = this.getCopyId();
        result = result * PRIME + ($copyId == null ? 43 : $copyId.hashCode());
        final Object $book = this.getBook();
        result = result * PRIME + ($book == null ? 43 : $book.hashCode());
        result = result * PRIME + (this.isAvailable() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "BookCopy(copyId=" + this.getCopyId() + ", book=" + this.getBook() + ", available=" + this.isAvailable() + ")";
    }
}