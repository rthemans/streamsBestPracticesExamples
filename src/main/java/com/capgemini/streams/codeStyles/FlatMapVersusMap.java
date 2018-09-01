package com.capgemini.streams.codeStyles;

import com.capgemini.streams.BestPracticeExample;
import com.capgemini.streams.common.Initialize;
import com.capgemini.streams.domain.Book;

import java.util.List;
import java.util.logging.Logger;

public class FlatMapVersusMap implements BestPracticeExample {
    private static final Logger LOGGER = Logger.getLogger(FlatMapVersusMap.class.getName());

    @Override
    public void good() {

    }

    @Override
    public void bad() {
        List<Book> books = Initialize.initializeBooks();
    }
}
