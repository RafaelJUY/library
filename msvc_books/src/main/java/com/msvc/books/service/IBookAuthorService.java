package com.msvc.books.service;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookAuthor;
import com.msvc.books.model.entity.BookAuthorPK;
import com.msvc.books.model.entity.BookEnt;

import java.util.List;

public interface IBookAuthorService extends IGenericCRUD<BookAuthor, BookAuthorPK>{
    List<AuthorEnt> findAuthors(BookEnt bookEnt);
    List<BookEnt> findBooks(AuthorEnt authorEnt);
    void delete(BookAuthor bookAuthor);
}
