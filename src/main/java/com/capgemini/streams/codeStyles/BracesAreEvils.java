package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.AbstractExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.service.LibraryService;
import com.google.inject.Inject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.capgemini.streams.common.StringUtils.NL;

/**
 * @author Raphael Themans
 */
public class BracesAreEvils extends AbstractExample {

    private List<Book> books;

    @Inject
    public BracesAreEvils(LibraryService libraryService, Logger logger) {
        super(libraryService, logger);
        books = libraryService.getAllBooks();
    }

    @Override
    public void good() {

        if (logger.isLoggable(Level.INFO)) {
            books.stream()
                    .filter(book -> book.getParutionDate().getYear() > 1991)
                    .map(this::describeBook)
                    .forEach(logger::info);
        }
    }

    private String describeBook(Book book) {
        return new StringBuilder()
                .append("The Author ")
                .append(book.getAuthor().getName())
                .append(" was alive after 1991 and wrote the book ")
                .append(book.getTitle())
                .append(".")
                .append(NL)
                .append("It contained the following chapters : ")
                .append(book.getChapters())
                .append(".")
                .toString();
    }

    @Override
    public void bad() {
        StringBuilder text = new StringBuilder();
        books.stream()
                .forEach(book -> {
                    // do evil code
                    if (book.getParutionDate().getYear() > 1991) {
                        text.setLength(0);
                        text.append("The Author ")
                                .append(book.getAuthor().getName())
                                .append(" was alive after 1991 and wrote the book ")
                                .append(book.getTitle())
                                .append(".")
                                .append(NL)
                                .append("It contained the following chapters : ")
                                .append(book.getChapters())
                                .append(".");
                        logger.info(() -> text.toString());
                    }
                });
    }

    public void old() {
        if (logger.isLoggable(Level.INFO)) {
            for (Book book : books) {
                if (book.getParutionDate().getYear() > 1991) {
                    StringBuilder text = new StringBuilder()
                            .append("The Author ")
                            .append(book.getAuthor().getName())
                            .append(" was alive after 1991 and wrote the book ")
                            .append(book.getTitle())
                            .append(".")
                            .append(NL)
                            .append("It contained the following chapters : ")
                            .append(book.getChapters())
                            .append(".");
                    logger.info(text::toString);
                }
            }
        }
    }
}
