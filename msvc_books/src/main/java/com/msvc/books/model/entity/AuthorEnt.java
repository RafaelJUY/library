package com.msvc.books.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class AuthorEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;
    private String nombre;
    private String apellido;
}
