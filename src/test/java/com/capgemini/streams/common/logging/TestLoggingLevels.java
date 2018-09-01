package com.capgemini.streams.common.logging;

import org.junit.Test;

import java.util.logging.Logger;

public class TestLoggingLevels {
    public static final Logger LOGGER = Logger.getLogger(TestLoggingLevels.class.getName());

    @Test
    public void testFullLog() {
        // setup

        // run
        LOGGER.finest("finest message");
        LOGGER.finer("finer message");
        LOGGER.fine("fine message");
        LOGGER.config("config message");
        LOGGER.info("info message");
        LOGGER.warning("warning message");
        LOGGER.severe("severe message");

        // verify
    }
}
