package com.example.library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreId;

    private String genreName;

    public Genre() {
    }

    public Long getGenreId() {
        return this.genreId;
    }

    public String getGenreName() {
        return this.genreName;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Genre)) return false;
        final Genre other = (Genre) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$genreId = this.getGenreId();
        final Object other$genreId = other.getGenreId();
        if (this$genreId == null ? other$genreId != null : !this$genreId.equals(other$genreId)) return false;
        final Object this$genreName = this.getGenreName();
        final Object other$genreName = other.getGenreName();
        if (this$genreName == null ? other$genreName != null : !this$genreName.equals(other$genreName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Genre;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $genreId = this.getGenreId();
        result = result * PRIME + ($genreId == null ? 43 : $genreId.hashCode());
        final Object $genreName = this.getGenreName();
        result = result * PRIME + ($genreName == null ? 43 : $genreName.hashCode());
        return result;
    }

    public String toString() {
        return "Genre(genreId=" + this.getGenreId() + ", genreName=" + this.getGenreName() + ")";
    }
}
