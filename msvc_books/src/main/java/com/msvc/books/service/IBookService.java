package com.msvc.books.service;

import com.msvc.books.model.entity.BookEnt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService extends IGenericCRUD<BookEnt, Integer>{
    List<BookEnt> findByTitle(String title);
    Page<BookEnt> findAllPage(Pageable pageable);
}
