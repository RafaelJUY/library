package com.msvc.partners.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msvc.partners.model.Book;
import com.msvc.partners.model.entity.LoanEnt;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {
    @EqualsAndHashCode.Include
    private Integer idPartner;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;
    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    private List<LoanEnt> loans = new ArrayList<>();

    private List<Book> books = new ArrayList<>();
}
