package com.manzanofp.voli.med.api.entities.patient;

import com.manzanofp.voli.med.api.entities.adress.DataAddress;
import jakarta.validation.constraints.NotNull;


public record DataUpdatePatient(
        @NotNull
        Long id,

        String name,

        String email,

        String cpf,

        String cellphone,

        DataAddress address

) {
}
