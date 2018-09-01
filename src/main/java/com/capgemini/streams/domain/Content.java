package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("text", text)
                .append("fontSize", fontSize)
                .append("fontPolicy", fontPolicy)
                .append("numberOfParagraphs", numberOfParagraphs)
                .toString();
    }
}
