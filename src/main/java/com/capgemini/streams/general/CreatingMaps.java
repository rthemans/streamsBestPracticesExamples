package com.capgemini.streams.general;

import com.capgemini.streams.common.AbstractExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.service.LibraryService;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CreatingMaps extends AbstractExample {

    /*
    credit https://marcin-chwedczuk.github.io/java-streams-best-practices
     */

    List<Book> books;

    public CreatingMaps(LibraryService libraryService, Logger logger) {
        super(libraryService, logger);
        books = libraryService.getAllBooks();
    }

    @Override
    public void good() {
        // frequent usage
        Map<String, Book> bookPerTitle = books.stream()
                .collect(ExtraCollectors.toPerTitleMap());
        logger.info(bookPerTitle::toString);
    }

    @Override
    public void bad() {
        // not frequent usage
        Map<String, Book> bookPerTitle = books.stream()
                .collect(toMap(Book::getTitle,identity()));
        logger.info(bookPerTitle::toString);
    }

    private static class ExtraCollectors {
        public static Collector<Book, ?, Map<String, Book>> toPerTitleMap() {
            return Collectors.toMap(Book::getTitle, identity());
        }
    }
}
