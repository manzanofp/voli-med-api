package com.manzanofp.voli.med.api.doctor;

import com.manzanofp.voli.med.api.adress.DataAddress;

public record DataRegisterDoctor(String name,
                                 String email,
                                 String crm,
                                 Specialty specialty,
                                 DataAddress address) {
}
