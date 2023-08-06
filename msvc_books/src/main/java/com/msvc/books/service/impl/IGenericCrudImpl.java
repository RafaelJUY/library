package com.msvc.books.service.impl;

import com.msvc.books.exception.ModelNotFoundException;
import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IGenericCRUD;

import java.util.List;

public interface IGenericCrudImpl<T, ID> extends IGenericCRUD<T, ID> {

    IGenericRepository<T, ID> getRepository();

    @Override
    default T findById(ID id) throws Exception {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    default List<T> findAll() throws Exception {
        return (List<T>) getRepository().findAll();
    }

    @Override
    default void deleteById(ID id) throws Exception {
        getRepository().deleteById(id);
    }

    @Override
    default T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    default boolean existsById(ID id) throws Exception {
        return getRepository().existsById(id);
    }
}
