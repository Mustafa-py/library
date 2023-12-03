package com.example.library.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    private User user;

    @ManyToOne
    private BookCopy bookCopy;

    private Date startDate;
    private Date endDate;

    public BookLoan() {
    }

    public Long getLoanId() {
        return this.loanId;
    }

    public User getUser() {
        return this.user;
    }

    public BookCopy getBookCopy() {
        return this.bookCopy;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BookLoan)) return false;
        final BookLoan other = (BookLoan) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$loanId = this.getLoanId();
        final Object other$loanId = other.getLoanId();
        if (this$loanId == null ? other$loanId != null : !this$loanId.equals(other$loanId)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$bookCopy = this.getBookCopy();
        final Object other$bookCopy = other.getBookCopy();
        if (this$bookCopy == null ? other$bookCopy != null : !this$bookCopy.equals(other$bookCopy)) return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        final Object this$endDate = this.getEndDate();
        final Object other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BookLoan;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $loanId = this.getLoanId();
        result = result * PRIME + ($loanId == null ? 43 : $loanId.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $bookCopy = this.getBookCopy();
        result = result * PRIME + ($bookCopy == null ? 43 : $bookCopy.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
        final Object $endDate = this.getEndDate();
        result = result * PRIME + ($endDate == null ? 43 : $endDate.hashCode());
        return result;
    }

    public String toString() {
        return "BookLoan(loanId=" + this.getLoanId() + ", user=" + this.getUser() + ", bookCopy=" + this.getBookCopy() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ")";
    }
}
