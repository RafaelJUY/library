package com.msvc.books.service;

import java.util.List;
import java.util.Optional;

public interface IGenericCRUD<T, ID> {
    Optional<T> findById(ID id) throws Exception;
    List<T> findAll() throws Exception;

    void deleteById(ID id) throws Exception;

    T save(T t) throws Exception;

    boolean existsById(ID id) throws Exception;
}
