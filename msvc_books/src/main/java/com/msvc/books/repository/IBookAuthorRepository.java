package com.msvc.books.repository;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookAuthor;
import com.msvc.books.model.entity.BookAuthorPK;
import com.msvc.books.model.entity.BookEnt;

import java.util.List;

public interface IBookAuthorRepository extends IGenericRepository<BookAuthor, BookAuthorPK>{
    List<BookAuthor> findBookAuthorsByBookEnt(BookEnt bookEnt);
    List<BookAuthor> findBookAuthorsByAuthorEnt(AuthorEnt authorEnt);
}
