package com.msvc.books.service.impl;

import com.msvc.books.model.entity.AuthorEnt;
import com.msvc.books.model.entity.BookAuthor;
import com.msvc.books.model.entity.BookAuthorPK;
import com.msvc.books.model.entity.BookEnt;
import com.msvc.books.repository.IBookAuthorRepository;
import com.msvc.books.repository.IGenericRepository;
import com.msvc.books.service.IBookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookAuthorServiceImpl implements IGenericCrudImpl<BookAuthor, BookAuthorPK>, IBookAuthorService {

    @Autowired
    private IBookAuthorRepository repository;

    @Override
    public IGenericRepository<BookAuthor, BookAuthorPK> getRepository() {
        return repository;
    }

    @Override
    public List<AuthorEnt> findAuthors(BookEnt bookEnt) {
        List<BookAuthor> bookAuthorList = repository.findBookAuthorsByBookEnt(bookEnt);

        return bookAuthorList.stream()
                .map(BookAuthor::getAuthorEnt)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookEnt> findBooks(AuthorEnt authorEnt) {
        List<BookAuthor> bookAuthorList = repository.findBookAuthorsByAuthorEnt(authorEnt);
        return bookAuthorList.stream()
                .map(BookAuthor::getBookEnt)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(BookAuthor bookAuthor) {
        repository.delete(bookAuthor);
    }
}
