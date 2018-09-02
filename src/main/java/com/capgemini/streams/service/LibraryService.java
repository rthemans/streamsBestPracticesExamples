package com.capgemini.streams.service;

import com.capgemini.streams.domain.Author;
import com.capgemini.streams.domain.Book;

import java.util.List;

public interface LibraryService {
    List<Book> getAllBooks();

    List<Author> getAllAuthors();
}
