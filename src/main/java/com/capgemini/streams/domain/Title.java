package com.capgemini.streams.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.awt.*;

public class Title {
    private String value;
    private int fontSize;

    private Font fontPolicy;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Title{");
        sb.append("value='").append(value).append('\'');
        sb.append(", fontSize=").append(fontSize);
        sb.append(", fontPolicy=").append(fontPolicy);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Title title = (Title) o;

        return new EqualsBuilder()
                .append(getFontSize(), title.getFontSize())
                .append(getValue(), title.getValue())
                .append(getFontPolicy(), title.getFontPolicy())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getValue())
                .append(getFontSize())
                .append(getFontPolicy())
                .toHashCode();
    }
}
