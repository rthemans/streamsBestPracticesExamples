package com.capgemini.streams.codeStyles;

import com.capgemini.streams.BestPracticeExample;
import com.capgemini.streams.domain.Book;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.capgemini.streams.common.Initialize.initializeBooks;
import static com.capgemini.streams.common.StringUtils.NL;

/**
 * @author Raphael Themans
 */
public class BracesAreEvils implements BestPracticeExample {

    public static final Logger LOGGER = Logger.getLogger(BracesAreEvils.class.getName());



    @Override
    public void good() {
        List<Book> books = initializeBooks();

        if (LOGGER.isLoggable(Level.INFO)) {
            books.stream()
                    .filter(book -> book.getParutionDate().getYear() > 1991)
                    .map(this::describeBook)
                    .forEach(LOGGER::info);
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
        List<Book> books = initializeBooks();

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
                        LOGGER.info(() -> text.toString());
                    }
                });
    }

    public void old() {
        List<Book> books = initializeBooks();

        if (LOGGER.isLoggable(Level.INFO)) {
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
                    LOGGER.info(text::toString);
                }
            }
        }
    }
}
