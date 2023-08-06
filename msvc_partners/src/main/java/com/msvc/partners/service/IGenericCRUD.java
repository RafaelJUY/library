package com.msvc.partners.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGenericCRUD<T, ID> {
    @Transactional(readOnly = true)
    T findByid(ID id) throws Exception;
    @Transactional(readOnly = true)
    List<T> findAll() throws Exception;
    @Transactional
    T save(T t) throws Exception;
    @Transactional
    void deleteById(ID id) throws Exception;
    @Transactional(readOnly = true)
    boolean existsByID(ID id) throws Exception;
}
