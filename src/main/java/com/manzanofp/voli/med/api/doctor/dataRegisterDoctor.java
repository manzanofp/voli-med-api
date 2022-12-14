package com.manzanofp.voli.med.api.doctor;

import com.manzanofp.voli.med.api.adress.DataAdress;

public record dataRegisterDoctor(String name, String email, String crm, Specialty specialty, DataAdress adress ) {
}
