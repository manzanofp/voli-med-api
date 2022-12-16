package com.manzanofp.voli.med.api.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
        @NotBlank
        String place,
        @NotBlank
        String district,
        @NotBlank
        @Pattern(regexp = "\\d{8}") //diz que o campo precisa ter 8 digitos
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String uf,
        String complement,
        String number) {
}
