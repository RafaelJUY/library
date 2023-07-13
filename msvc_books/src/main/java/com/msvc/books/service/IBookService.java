package com.msvc.books.service;

import com.msvc.books.model.entity.BookEnt;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Optional<BookEnt> findById(Integer id) throws Exception;
    List<BookEnt> findAll() throws Exception;

    void deleteById(Integer id) throws Exception;

    BookEnt save(BookEnt bookEnt) throws Exception;

    boolean existsById(Integer id) throws Exception;
}
