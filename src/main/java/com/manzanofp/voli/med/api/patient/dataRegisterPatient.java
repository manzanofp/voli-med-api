package com.manzanofp.voli.med.api.patient;

import com.manzanofp.voli.med.api.adress.DataAddress;


public record dataRegisterPatient(
        String name,
        String email,
        String telephone,
        String cpf,
        DataAddress address
) {
}
