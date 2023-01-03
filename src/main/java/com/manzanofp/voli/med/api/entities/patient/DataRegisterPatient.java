package com.manzanofp.voli.med.api.entities.patient;

import com.manzanofp.voli.med.api.entities.adress.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DataRegisterPatient(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String cellphone,
        @NotBlank
                @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotNull
        @Valid
        DataAddress address
) {
}
