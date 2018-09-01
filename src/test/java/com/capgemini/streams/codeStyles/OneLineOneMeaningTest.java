package com.capgemini.streams.codeStyles;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneLineOneMeaningTest {
    private OneLineOneMeaning target;

    @Before
    public void setup() {
        target = new OneLineOneMeaning();
    }

    @Test
    public void good() {
        target.good();
    }

    @Test
    public void bad() {
        target.bad();
    }
}