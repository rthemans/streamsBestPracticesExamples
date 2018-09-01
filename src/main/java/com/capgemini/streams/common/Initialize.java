////////////////////////////////////////////////////////////////////
//
// File: Initialize.java
// Created: 17-07-18 12:54
// Author: FJM575 (Raphael Themans)
// Electrabel n.v./s.a., Regentlaan 8 Boulevard du Régent, BTW BE 0403.107.701 - 1000 Brussel/Bruxelles, Belgium.
//
// Proprietary Notice:
// This software is the confidential and proprietary information of Electrabel s.a./n.v. and/or its licensors. 
// You shall not disclose this Confidential Information to any third parties
// and any use thereof shall be subject to the terms and conditions of use, as agreed upon with Electrabel in writing.
//
////////////////////////////////////////////////////////////////////
package com.capgemini.streams.common;

import com.capgemini.streams.domain.Author;
import com.capgemini.streams.domain.Book;
import com.capgemini.streams.domain.Chapter;
import com.capgemini.streams.domain.Title;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * @author FJM575 (Raphael Themans)
 */
public class Initialize {

    public static final String ROBIN_HOBB = "Robin Hobb";
    public static final String RENE_DESCARTES = "Rene Descartes";

    public static List<Author> initializeAuthors() {
        List<Author> result = new ArrayList<>();
        Author robinHobb = new Author();
        result.add(robinHobb);
        robinHobb.setLanguage(Locale.ENGLISH);
        robinHobb.setBirthDate(LocalDate.of(1952, 3, 5));
        robinHobb.setCountry("USA - California");
        robinHobb.setName(ROBIN_HOBB);

        Author reneDescartes = new Author();
        result.add(reneDescartes);
        reneDescartes.setLanguage(Locale.FRENCH);
        reneDescartes.setBirthDate(LocalDate.of(1596,3,31));
        reneDescartes.setDeathDate(LocalDate.of(1650, 02, 11));
        reneDescartes.setCountry("Kingdom of France");
        reneDescartes.setName(RENE_DESCARTES);
        return result;
    }

    public static List<Book> initializeBooks() {
        Map<String, Author> authorsPerName = initializeAuthors().stream()
                .collect(toMap(Author::getName, Function.identity()));

        List<Book> result = new ArrayList<>();
        {
            Book book = new Book();
            result.add(book);
            book.setAuthor(authorsPerName.get(ROBIN_HOBB));
            book.setTitle("Assassin's Apprentice");
            // "The earliest history", "Newboy", "Covenant", "Apprenticeship"
            List<Chapter> chapters = new ArrayList<>();
            {
                Chapter chapter = new Chapter();
                Title chapterTitle = new Title();
                chapterTitle.setValue("The earliest history");
                chapterTitle.setFontPolicy(Font.getFont("Garamond"));
                chapterTitle.setFontSize(16);
                chapter.setTitle(chapterTitle);
            }
            book.setChapters(chapters);
            book.setParutionDate(LocalDate.of(1995,04,01));
        }
        {
            Book book = new Book();
            result.add(book);
            book.setAuthor(authorsPerName.get(ROBIN_HOBB));
            book.setTitle("Harpy's Flight");
            book.setParutionDate(LocalDate.of(1983, 1, 1));
        }
        {
            Book book = new Book();
            result.add(book);
            book.setAuthor(authorsPerName.get(RENE_DESCARTES));
            book.setTitle("Discourse on the Method");
            book.setParutionDate(LocalDate.of(1637, 1, 1));
        }
        return result;
    }
}
