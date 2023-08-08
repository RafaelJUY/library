package com.msvc.partners.clients;

import com.msvc.partners.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "msvc-books", url = "localhost:8001")
public interface IBookClientRest {

    @PutMapping("/books/lend/{id}")
    Book lendBook(@PathVariable(name = "id") Integer idBook);

    @PutMapping("/books/return-book/{id}")
    Book returnBookLoan(@PathVariable(name = "id") Integer idBook);

}
