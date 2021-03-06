package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.AbstractExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.service.LibraryService;
import com.google.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

public class MethodReference extends AbstractExample {

    private List<Book> books;

    @Inject
    public MethodReference(LibraryService libraryService, Logger logger) {
        super(libraryService, logger);
        books = libraryService.getAllBooks();
    }

    @Override
    public void good() {
        List<Book> copies = books.stream()
                .map(this::copyBook)
                .collect(toList());
        logger.info(() -> copies.toString());
    }

    @Override
    public void bad() {
        List<Book> copies = books.stream()
                .map(book -> copyBook(book))
                .collect(toList());
        logger.info(() -> copies.toString());
    }

    private Book copyBook(Book book) {
        Book copy = new Book();
        copy.setAuthor(book.getAuthor());
        copy.setParutionDate(book.getParutionDate());
        copy.setTitle(book.getTitle());
        // as a Chapter is mutable, should probably not do this
        copy.setChapters(book.getChapters());
        return copy;
    }
}
