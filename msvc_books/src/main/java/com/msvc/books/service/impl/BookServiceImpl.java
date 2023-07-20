package com.msvc.books.service.impl;

import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.repository.IBookRepository;
import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IGenericCrudImpl<BookEnt, Integer>, IBookService {

    @Autowired
    private IBookRepository repository;


    @Override
    public IGenericRepository<BookEnt, Integer> getRepository() {
        return repository;
    }

    @Override
    public List<BookEnt> findByTitle(String title) {
        return repository.findByTitleContainsIgnoreCase(title);
    }

    @Override
    public Page<BookEnt> findAllPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
