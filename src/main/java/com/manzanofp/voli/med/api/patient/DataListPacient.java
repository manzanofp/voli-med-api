package com.manzanofp.voli.med.api.patient;

public record DataListPacient(String name, String email, String cpf) {

    public DataListPacient(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
