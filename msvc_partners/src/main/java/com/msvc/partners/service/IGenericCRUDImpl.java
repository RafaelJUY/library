package com.msvc.partners.service;

import com.msvc.partners.exception.ModelNotFoundException;
import com.msvc.partners.repository.IGenericRepository;
import com.msvc.partners.service.IGenericCRUD;

import java.util.List;
import java.util.NoSuchElementException;

public interface IGenericCRUDImpl<T,ID> extends IGenericCRUD<T, ID> {

    IGenericRepository<T, ID> getRepository();

    @Override
    default T findByid(ID id) throws Exception {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    default List<T> findAll() throws Exception {
        List<T> list = getRepository().findAll();
        if (list.isEmpty()){
            throw new ModelNotFoundException("No records loaded");
        }

        return list;
    }

    @Override
    default T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    default void deleteById(ID id) throws Exception {
        if (this.existsByID(id)){
            getRepository().deleteById(id);
        }else{
            throw new ModelNotFoundException("ID NOT FOUND " + id);
        }
    }

    @Override
    default boolean existsByID(ID id) throws Exception {
        return getRepository().existsById(id);
    }
}
