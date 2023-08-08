package com.msvc.books.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "books")
public class BookEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idBook;
    @Column(length = 150, nullable = false)
    private String title;
    private Byte quantity;

    public boolean lendUnity(){
        boolean ok = true;
        if (this.quantity >= 1){
            quantity = (byte) (quantity - 1);
        } else {
            ok = false;
        }
        return ok;
    }

    public void returnUnity(){
        quantity = (byte) (quantity + 1);
    }
}
