package com.msvc.books;

import static com.msvc.books.AuthorData.*;
import static com.msvc.books.BookData.*;

import com.msvc.books.model.entity.BookAuthor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookAuthorData {
    public static List<BookAuthor> book1Authors(){
        BookAuthor bookAuthor1 = new BookAuthor(createAuthor001(), createBook001());
        BookAuthor bookAuthor2 = new BookAuthor(createAuthor002(), createBook001());

        return Arrays.asList(bookAuthor1, bookAuthor2);
    }

    public static List<BookAuthor> book2Authors(){
        BookAuthor bookAuthor1 = new BookAuthor(createAuthor001(), createBook002());

        return Arrays.asList(bookAuthor1);
    }

    public static List<BookAuthor> book3Authors(){
        return List.of();
    }
}
