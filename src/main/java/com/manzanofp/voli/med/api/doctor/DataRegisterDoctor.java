package com.manzanofp.voli.med.api.doctor;

import com.manzanofp.voli.med.api.adress.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DataRegisterDoctor(

        @NotBlank         //utilizado só em Strings, ele faz com que o campo seja preenchido e verifica se é vazio
        String name,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String cellphone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull      //diz que o campo não pode ser vazio
        Specialty specialty,
        @NotNull
        @Valid
        DataAddress address) {
}
