package com.msvc.books.service.impl;

import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.repository.IBookRepository;
import com.msvc.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository repository;


    @Override
    public Optional<BookEnt> findById(Integer id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public List<BookEnt> findAll() throws Exception {
        return (List<BookEnt>) repository.findAll();
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public BookEnt save(BookEnt bookEnt) throws Exception {
        return repository.save(bookEnt);
    }

    @Override
    public boolean existsById(Integer id) throws Exception {
        return repository.existsById(id);
    }
}
