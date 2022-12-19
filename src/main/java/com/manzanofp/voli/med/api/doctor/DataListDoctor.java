package com.manzanofp.voli.med.api.doctor;

public record DataListDoctor(String name, String email, String crm, Specialty specialty ) {

    public DataListDoctor(Doctor doctor){
        this(doctor.getName(), doctor.getCrm(), doctor.getEmail(), doctor.getSpecialty());
    }
}
