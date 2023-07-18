package com.msvc.books.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String title;
    private Byte quantity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AuthorDto> authors;
}
