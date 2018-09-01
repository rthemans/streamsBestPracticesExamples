////////////////////////////////////////////////////////////////////
//
// File: OneLineOneMeaning.java
// Created: 17-07-18 09:28
// Author: FJM575 (Raphael Themans)
// Electrabel n.v./s.a., Regentlaan 8 Boulevard du Régent, BTW BE 0403.107.701 - 1000 Brussel/Bruxelles, Belgium.
//
// Proprietary Notice:
// This software is the confidential and proprietary information of Electrabel s.a./n.v. and/or its licensors. 
// You shall not disclose this Confidential Information to any third parties
// and any use thereof shall be subject to the terms and conditions of use, as agreed upon with Electrabel in writing.
//
////////////////////////////////////////////////////////////////////
package com.capgemini.streams.codeStyles;

import com.capgemini.streams.BestPracticeExample;
import com.capgemini.streams.common.Initialize;
import com.capgemini.streams.domain.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * @author FJM575 (Raphael Themans)
 */
public class OneLineOneMeaning implements BestPracticeExample {
    private static final Logger LOGGER = Logger.getLogger(OneLineOneMeaning.class.getName());

    @Override
    public void good() {
            List<Book> books = Initialize.initializeBooks();
            LocalDate startParutionDate =  LocalDate.of(1991,06,12);

            {
                Map<String, Book> booksPerAuthorName = books.stream()
                        .filter(book -> !book.getAuthor().isDead())
                        .filter(book -> book.getParutionDate().isAfter(startParutionDate))
                        .collect(toMap(
                                book -> book.getAuthor().getName(),
                                identity()));

                LOGGER.info(() -> booksPerAuthorName.toString());
            }
    }

    @Override
    public void bad() {
        List<Book> books = Initialize.initializeBooks();
        LocalDate startParutionDate =  LocalDate.of(1991,06,12);

        {
            Map<String, Book> booksPerAuthorName = books.stream().filter(book -> !book.getAuthor().isDead()).filter(book -> book.getParutionDate()
                    .isAfter(startParutionDate)).collect(toMap(book -> book.getAuthor().getName(), book -> book));

            LOGGER.info(() -> booksPerAuthorName.toString());
        }
    }
}
