package com.capgemini.streams.general;

import com.capgemini.streams.common.AbstractExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.service.LibraryService;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class Sorting extends AbstractExample {

    /*
    credit https://marcin-chwedczuk.github.io/java-streams-best-practices
     */

    private List<Book> books;

    public Sorting(LibraryService libraryService, Logger logger) {
        super(libraryService, logger);
        books = libraryService.getAllBooks();
    }

    @Override
    public void good() {

    }

    @Override
    public void bad() {
    }
}
