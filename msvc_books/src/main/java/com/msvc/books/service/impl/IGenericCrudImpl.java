package com.msvc.books.service.impl;

import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IGenericCRUD;

import java.util.List;
import java.util.Optional;

public interface IGenericCrudImpl<T, ID> extends IGenericCRUD<T, ID> {

    IGenericRepository<T, ID> getRepository();

    @Override
    default Optional<T> findById(ID id) throws Exception {
        return getRepository().findById(id);
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
