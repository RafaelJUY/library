package com.msvc.books.service.impl;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.repository.IAuthorRepository;
import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IGenericCrudImpl<AuthorEnt, Integer>, IAuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Override
    public IGenericRepository<AuthorEnt, Integer> getRepository() {
        return repository;
    }
}
