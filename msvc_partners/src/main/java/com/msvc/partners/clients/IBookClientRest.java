package com.msvc.partners.clients;

import com.msvc.partners.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-books", url = "localhost:8001")
public interface IBookClientRest {

    @GetMapping("/books/{idBook}")
    Book findById(@PathVariable Integer idBook);
}
