package com.capgemini.streams.service.impl;

import com.capgemini.streams.domain.*;
import com.capgemini.streams.service.LibraryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.awt.Font.getFont;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class LibraryServiceIntegrationTestImpl implements LibraryService {
    public static final String ROBIN_HOBB = "Robin Hobb";
    public static final String RENE_DESCARTES = "Rene Descartes";

    @Override
    public List<Author> getAllAuthors() {
        List<Author> result = new ArrayList<>();
        Author robinHobb = new Author();
        result.add(robinHobb);
        robinHobb.setLanguage(Locale.ENGLISH);
        robinHobb.setBirthDate(LocalDate.of(1952, 3, 5));
        robinHobb.setCountry("USA");
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

    @Override
    public List<Book> getAllBooks() {
        Map<String, Author> authorsPerName = getAllAuthors().stream()
                .collect(toMap(Author::getName, identity()));

        List<Book> result = new ArrayList<>();
        {
            Book book = new Book();
            result.add(book);
            book.setAuthor(authorsPerName.get(ROBIN_HOBB));
            book.setTitle("Assassin's Apprentice");
            List<Chapter> chapters = new ArrayList<>();
            {
                Chapter chapter = getDefaultChapter();
                chapter.getTitle().setValue("The earliest history");

                chapter.getContent().setNumberOfParagraphs(234);

                chapter.setStartingPage(11);
                chapter.setNumberOfPages(17);

                chapters.add(chapter);
            }
            {
                Chapter chapter = getDefaultChapter();
                chapter.getTitle().setValue("Newboy");

                chapter.getContent().setNumberOfParagraphs(245);

                chapter.setStartingPage(28);
                chapter.setNumberOfPages(23);

                chapters.add(chapter);
            }
            {
                Chapter chapter = getDefaultChapter();
                chapter.getTitle().setValue("Covenant");

                chapter.getContent().setNumberOfParagraphs(201);

                chapter.setStartingPage(51);
                chapter.setNumberOfPages(29);

                chapters.add(chapter);
            }
            {
                Chapter chapter = getDefaultChapter();
                chapter.getTitle().setValue("Apprenticeship");

                chapter.getContent().setNumberOfParagraphs(323);

                chapter.setStartingPage(70);
                chapter.setNumberOfPages(17);

                chapters.add(chapter);
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

    private Chapter getDefaultChapter() {
        Chapter chapter = new Chapter();

        Title chapterTitle = new Title();
        chapterTitle.setFontSize(16);
        chapterTitle.setFontPolicy(getFont("Arial"));
        chapter.setTitle(chapterTitle);

        Content content = new Content();
        content.setFontPolicy(getFont("Georgia"));
        content.setFontSize(12);
        content.setText("text under copyright");
        chapter.setContent(content);

        return  chapter;
    }
}