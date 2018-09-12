package com.capgemini.streams.common;

import com.capgemini.streams.service.LibraryService;

import java.util.logging.Logger;

public abstract class AbstractExample implements BestPracticeExample {

    protected Logger logger;
    protected LibraryService libraryService;

    public AbstractExample(LibraryService libraryService, Logger logger) {
        this.logger = logger;
        this.libraryService = libraryService;
    }
}
