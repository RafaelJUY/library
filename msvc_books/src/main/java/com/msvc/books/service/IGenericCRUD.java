package com.msvc.books.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IGenericCRUD<T, ID> {
    @Transactional(readOnly = true)
    Optional<T> findById(ID id) throws Exception;

    @Transactional
    List<T> findAll() throws Exception;

    @Transactional
    void deleteById(ID id) throws Exception;

    @Transactional
    T save(T t) throws Exception;

    @Transactional(readOnly = true)
    boolean existsById(ID id) throws Exception;
}
