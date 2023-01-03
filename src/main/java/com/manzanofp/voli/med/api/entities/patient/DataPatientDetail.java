package com.manzanofp.voli.med.api.entities.patient;

import com.manzanofp.voli.med.api.entities.adress.Address;

public record DataPatientDetail(Long id, String name, String email, String cpf, String cellphone, Address address) {

    public DataPatientDetail(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCellphone(),patient.getCpf() ,patient.getAddress());
    }

}
