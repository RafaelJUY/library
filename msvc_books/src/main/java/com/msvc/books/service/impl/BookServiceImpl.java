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
    public Optional<BookEnt> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<BookEnt> findAll() {
        return (List<BookEnt>) repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public BookEnt save(BookEnt bookEnt) {
        return repository.save(bookEnt);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}
