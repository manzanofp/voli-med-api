package com.manzanofp.voli.med.api.entities.doctor;

import com.manzanofp.voli.med.api.entities.adress.Address;

public record DataDoctorDetail(Long id, String name, String email, String crm, String cellphone, Specialty specialty, Address address) {

    public DataDoctorDetail(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getCellphone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
