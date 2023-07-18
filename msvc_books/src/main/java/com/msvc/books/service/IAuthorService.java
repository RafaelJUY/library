package com.msvc.books.service;

import com.msvc.books.model.entity.AuthorEnt;

import java.util.List;

public interface IAuthorService extends IGenericCRUD<AuthorEnt, Integer> {
    boolean existsAllById(List<Integer> ids);

    List<AuthorEnt> findAllById(List<Integer> ids);
}
