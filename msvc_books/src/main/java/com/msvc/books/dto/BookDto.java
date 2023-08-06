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
public class BookDto {
    @EqualsAndHashCode.Include
    private Integer idBook;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 150)
    @NotBlank
    private String title;
    @Min(value = 0)
    @Max(value = 127)
    private Byte quantity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AuthorDto> authors;
}
