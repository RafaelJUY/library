package com.msvc.books.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private AuthorEnt authorEnt;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private BookEnt bookEnt;
}
