package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.awt.*;

public class Content {
    private String text;
    private int fontSize;
    private Font fontPolicy;
    private int numberOfParagraphs;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Font getFontPolicy() {
        return fontPolicy;
    }

    public void setFontPolicy(Font fontPolicy) {
        this.fontPolicy = fontPolicy;
    }

    public int getNumberOfParagraphs() {
        return numberOfParagraphs;
    }

    public void setNumberOfParagraphs(int numberOfParagraphs) {
        this.numberOfParagraphs = numberOfParagraphs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Content{");
        sb.append("text='").append(text).append('\'');
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontPolicy=").append(fontPolicy);
        sb.append(", numberOfParagraphs=").append(numberOfParagraphs);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        return new EqualsBuilder()
                .append(getFontSize(), content.getFontSize())
                .append(getNumberOfParagraphs(), content.getNumberOfParagraphs())
                .append(getText(), content.getText())
                .append(getFontPolicy(), content.getFontPolicy())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getText())
                .append(getFontSize())
                .append(getFontPolicy())
                .append(getNumberOfParagraphs())
                .toHashCode();
    }

}
