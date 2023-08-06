package com.msvc.books;

import com.msvc.books.dto.BookDto;
import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookEnt;

import java.util.Arrays;
import java.util.List;

public class BookData {
    public static BookEnt createBook001() {
        return new BookEnt(1, "title_1", (byte) 10);
    }

    public static BookEnt createBook002() {
        return new BookEnt(2, "title_2", (byte) 20);
    }

    public static BookEnt createBook003() {
        return new BookEnt(3, "title_3", (byte) 30);
    }

    public static List<BookEnt> allBooks(){
        return Arrays.asList(createBook001(), createBook002(), createBook003());
    }

//    public static BookDto createBookDto(){
//        return new BookDto(null, "title_4", (byte)40, null);
//    }
}
