package com.msvc.books.repository;

import com.msvc.books.model.entity.AuthorEnt;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends IGenericRepository<AuthorEnt, Integer> {
}
