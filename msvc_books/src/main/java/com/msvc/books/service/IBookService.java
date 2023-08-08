package com.msvc.books.service;

import com.msvc.books.model.entity.BookEnt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookService extends IGenericCRUD<BookEnt, Integer>{
    @Transactional(readOnly = true)
    List<BookEnt> findByTitle(String title);
    @Transactional(readOnly = true)
    Page<BookEnt> findAllPage(Pageable pageable);
    @Transactional
    BookEnt lendBook(Integer id) throws Exception;
    @Transactional
    BookEnt returnBookLoan(Integer id) throws Exception;

}
