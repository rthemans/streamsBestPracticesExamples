package com.capgemini.streams.codeStyles;

import org.junit.Before;
import org.junit.Test;

public class BracesAreEvilsTest {
    private BracesAreEvils target;

    @Before
    public void setUp() throws Exception {
        target = new BracesAreEvils();
    }

    @Test
    public void good() {
        target.good();
    }

    @Test
    public void bad() {
        target.bad();
    }

    @Test
    public void old() {
        target.old();
    }
}