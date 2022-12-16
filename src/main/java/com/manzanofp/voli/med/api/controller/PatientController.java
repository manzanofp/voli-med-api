package com.manzanofp.voli.med.api.controller;


import com.manzanofp.voli.med.api.patient.DataRegisterPatient;
import com.manzanofp.voli.med.api.patient.Patient;
import com.manzanofp.voli.med.api.patient.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public void register (@RequestBody @Valid DataRegisterPatient data){
        patientRepository.save(new Patient(data));
    }


}
