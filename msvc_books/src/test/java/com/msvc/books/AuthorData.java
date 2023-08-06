package com.msvc.books;

import com.msvc.books.model.entity.AuthorEnt;

import java.util.Arrays;
import java.util.List;

public class AuthorData {
    public static AuthorEnt createAuthor001(){
        return new AuthorEnt(1, "first_name_1", "last_name_1");
    }

    public static AuthorEnt createAuthor002(){
        return new AuthorEnt(2, "first_name_2", "last_name_2");
    }

    public static AuthorEnt createAuthor003(){
        return new AuthorEnt(3, "first_name_3", "last_name_3");
    }

    public static List<AuthorEnt> allAuthors(){
        return Arrays.asList(createAuthor001(), createAuthor002(), createAuthor003());
    }
}
