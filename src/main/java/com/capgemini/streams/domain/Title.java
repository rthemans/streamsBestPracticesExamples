package com.capgemini.streams.domain;

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
        return new ToStringBuilder(this)
                .append("value", value)
                .append("fontSize", fontSize)
                .append("fontPolicy", fontPolicy)
                .toString();
    }
}
