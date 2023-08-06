package com.msvc.partners.dto;

import jakarta.validation.constraints.*;
import lombok.*;

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
}
