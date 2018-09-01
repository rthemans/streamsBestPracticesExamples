package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Chapter {
    private Title title;
    private int startingPage;
    private int numberOfPages;
    private Content content;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public void setStartingPage(int startingPage) {
        this.startingPage = startingPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        return new EqualsBuilder()
                .append(getStartingPage(), chapter.getStartingPage())
                .append(getNumberOfPages(), chapter.getNumberOfPages())
                .append(getTitle(), chapter.getTitle())
                .append(getContent(), chapter.getContent())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getTitle())
                .append(getStartingPage())
                .append(getNumberOfPages())
                .append(getContent())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("startingPage", startingPage)
                .append("numberOfPages", numberOfPages)
                .append("content", content)
                .toString();
    }
}
