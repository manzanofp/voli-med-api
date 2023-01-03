package com.manzanofp.voli.med.api.entities.doctor;

public record DataListDoctor(Long id, String name, String email, String crm, Specialty specialty ) {

    public DataListDoctor(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getCrm(), doctor.getEmail(), doctor.getSpecialty());
    }
}
