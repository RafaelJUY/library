package com.msvc.partners.model.entity;

import com.msvc.partners.model.Book;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partners")
public class PartnerEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPartner;
    @Column(name = "first_name",length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 50, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partner")
    private List<LoanEnt> loans = new ArrayList<>();
    @Transient
    private List<Book> books = new ArrayList<>();


    public boolean addLoan(LoanEnt loan){
        return this.loans.add(loan);
    }

    public void returnLoad(LoanEnt loan) throws Exception {
        this.existsLoan(loan);

        this.loans.stream().parallel().forEach(l -> {
            if (l.equals(loan)){
                l.setReturnDate(LocalDateTime.now());
            }
        });
    }

    private void existsLoan(LoanEnt loan) throws Exception {
        if (!this.loans.contains(loan)){
            throw new Exception("the loan is not from this partner");
        }
    }
}
