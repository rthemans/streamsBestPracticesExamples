package com.capgemini.streams.codeStyles;

import com.capgemini.streams.common.BestPracticeExample;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.domain.Chapter;
import com.capgemini.streams.domain.Content;
import com.capgemini.streams.service.LibraryService;
import com.google.inject.Inject;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class FlatMapVersusMap implements BestPracticeExample {
    private final Logger logger;

    private final List<Book> books;

    @Inject
    public FlatMapVersusMap(LibraryService libraryService, Logger logger) {
        this.logger = logger;
        this.books = libraryService.getAllBooks();
    }

    @Override
    public void good() {
        books.stream()
                .map(Book::getChapters)
                .flatMap(Collection::stream)
                .map(Chapter::getContent)
                .map(Content::getText)
                .map(String::chars)
                .flatMap(IntStream::boxed)
                .map(String::valueOf)
                .forEach(logger::info);
    }

    @Override
    public void bad() {
        books.stream()
                .flatMap(book -> book.getChapters().stream())
                .flatMap(chapter -> chapter.getContent().getText().chars().boxed())
                .map(val -> val.toString())
                .forEach(logger::info);
    }
}
