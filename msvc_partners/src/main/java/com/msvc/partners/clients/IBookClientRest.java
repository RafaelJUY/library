package com.msvc.partners.clients;

import com.msvc.partners.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "msvc-books", url = "${msvc.books.url}")
public interface IBookClientRest {

    @PutMapping("/api/books/lend/{id}")
    Book lendBook(@PathVariable(name = "id") Integer idBook);

    @PutMapping("/api/books/return-book/{id}")
    Book returnBookLoan(@PathVariable(name = "id") Integer idBook);

    @GetMapping("/api/books/{id}")
    Book findBookById(@PathVariable(name = "id") Integer id);

}
