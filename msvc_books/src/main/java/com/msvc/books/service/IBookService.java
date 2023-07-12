package com.msvc.books.service;

import com.msvc.books.model.entity.BookEnt;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Optional<BookEnt> findById(Integer id);
    List<BookEnt> findAll();

    void deleteById(Integer id);

    BookEnt save(BookEnt bookEnt);

    boolean existsById(Integer id);
}
