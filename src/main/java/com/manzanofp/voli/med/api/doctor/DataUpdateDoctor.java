package com.manzanofp.voli.med.api.doctor;

import com.manzanofp.voli.med.api.adress.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String cellphone,
        DataAddress address) {
}
