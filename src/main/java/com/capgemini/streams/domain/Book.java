////////////////////////////////////////////////////////////////////
//
// File: Book.java
// Created: 17-07-18 09:37
// Author: FJM575 (Raphael Themans)
// Electrabel n.v./s.a., Regentlaan 8 Boulevard du Régent, BTW BE 0403.107.701 - 1000 Brussel/Bruxelles, Belgium.
//
// Proprietary Notice:
// This software is the confidential and proprietary information of Electrabel s.a./n.v. and/or its licensors. 
// You shall not disclose this Confidential Information to any third parties
// and any use thereof shall be subject to the terms and conditions of use, as agreed upon with Electrabel in writing.
//
////////////////////////////////////////////////////////////////////
package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FJM575 (Raphael Themans)
 */
public class Book {
    private LocalDate parutionDate;
    private Author author;
    private String title;
    private List<Chapter> chapters = new ArrayList<>();

    public LocalDate getParutionDate() {
        return LocalDate.from(parutionDate);
    }

    public void setParutionDate(LocalDate parutionDate) {
        this.parutionDate = parutionDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters.clear();
        this.chapters.addAll(chapters);
    }

    public void setChapters(Chapter... chapters) {
        setChapters(Arrays.asList(chapters));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getParutionDate(), book.getParutionDate())
                .append(getAuthor(), book.getAuthor())
                .append(getTitle(), book.getTitle())
                .append(getChapters(), book.getChapters())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getParutionDate())
                .append(getAuthor())
                .append(getTitle())
                .append(getChapters())
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("parutionDate=").append(parutionDate);
        sb.append(", author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", chapters=").append(chapters);
        sb.append('}');
        return sb.toString();
    }
}
