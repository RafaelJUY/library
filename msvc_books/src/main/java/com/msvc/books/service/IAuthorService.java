package com.msvc.books.service;

import com.msvc.books.model.entity.AuthorEnt;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAuthorService extends IGenericCRUD<AuthorEnt, Integer> {
    @Transactional(readOnly = true)
    boolean existsAllById(List<Integer> ids);
    @Transactional(readOnly = true)
    List<AuthorEnt> findAllById(List<Integer> ids);
}
