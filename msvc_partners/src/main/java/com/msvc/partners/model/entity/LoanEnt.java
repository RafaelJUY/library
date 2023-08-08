package com.msvc.partners.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "loans")
public class LoanEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idLoan;
    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate = LocalDateTime.now();
    @Column(name = "return_date", nullable = true)
    private LocalDateTime returnDate;
    @Column(name = "id_book", nullable = false)
    private Integer idBook;
}
