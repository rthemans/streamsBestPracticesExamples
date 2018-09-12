package com.capgemini.streams.general;

import com.capgemini.streams.common.AbstractExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.service.LibraryService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

public class Casting extends AbstractExample {

    /*
    credit https://marcin-chwedczuk.github.io/java-streams-best-practices
     */

    private List<Object> objects = new ArrayList<>();

    @Inject
    public Casting(LibraryService libraryService, Logger logger) {
        super(libraryService, logger);
        objects.addAll(libraryService.getAllAuthors());
        objects.addAll(libraryService.getAllBooks());
    }

    @Override
    public void good() {
        List<Book> books = objects.stream()
                .filter(Book.class::isInstance)
                .map(Book.class::cast)
                .collect(toList());
        logger.info(books::toString);
    }

    @Override
    public void bad() {
        List<Book> books = objects.stream()
                .filter(object -> object instanceof Book)
                .map(object -> (Book) object)
                .collect(toList());
        logger.info(books::toString);
    }
}
