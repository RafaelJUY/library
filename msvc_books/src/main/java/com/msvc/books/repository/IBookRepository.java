package com.msvc.books.repository;

import com.msvc.books.model.entity.BookEnt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<BookEnt, Integer> {
}
