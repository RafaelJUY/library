package com.msvc.books.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AuthorDto {

    @EqualsAndHashCode.Include
    private Integer idAuthor;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    @NotBlank
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    @NotBlank
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BookDto> books;
}
