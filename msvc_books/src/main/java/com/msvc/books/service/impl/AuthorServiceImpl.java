package com.msvc.books.service.impl;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.repository.IAuthorRepository;
import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IGenericCrudImpl<AuthorEnt, Integer>, IAuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Override
    public IGenericRepository<AuthorEnt, Integer> getRepository() {
        return repository;
    }


    @Override
    public boolean existsAllById(List<Integer> ids) {
        boolean exists = true;
        for (Integer id : ids) {
            if (!repository.existsById(id)){
                exists = false;
                break;
            }
        }
        return exists;
    }

    @Override
    public List<AuthorEnt> findAllById(List<Integer> ids) {
        return repository.findAllById(ids);
    }
}
