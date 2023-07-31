package com.msvc.books.service;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookAuthor;
import com.msvc.books.model.entity.BookAuthorPK;
import com.msvc.books.model.entity.BookEnt;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookAuthorService extends IGenericCRUD<BookAuthor, BookAuthorPK>{
    @Transactional(readOnly = true)
    List<AuthorEnt> findAuthors(BookEnt bookEnt);
    @Transactional(readOnly = true)
    List<BookEnt> findBooks(AuthorEnt authorEnt);
    @Transactional
    void delete(BookAuthor bookAuthor);
}
