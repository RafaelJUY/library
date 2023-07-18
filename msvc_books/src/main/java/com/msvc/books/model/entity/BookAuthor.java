package com.msvc.books.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books_authors")
@IdClass(BookAuthorPK.class)
public class BookAuthor {
    @Id
    private AuthorEnt authorEnt;

    @Id
    private BookEnt bookEnt;
}
