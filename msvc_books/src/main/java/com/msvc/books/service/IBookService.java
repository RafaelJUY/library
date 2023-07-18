package com.msvc.books.service;

import com.msvc.books.model.entity.BookEnt;

import java.util.List;
import java.util.Optional;

public interface IBookService extends IGenericCRUD<BookEnt, Integer>{
    List<BookEnt> findByTitle(String title);
}
