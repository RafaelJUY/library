package com.msvc.books.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class AuthorEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;
    private String nombre;
    private String apellido;
}
