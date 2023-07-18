package com.msvc.books.repository;

import com.msvc.books.model.entity.BookEnt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends IGenericRepository<BookEnt, Integer> {
    List<BookEnt> findByTitleContainsIgnoreCase(String title);
}
