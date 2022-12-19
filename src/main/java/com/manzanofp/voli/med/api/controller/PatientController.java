package com.manzanofp.voli.med.api.controller;


import com.manzanofp.voli.med.api.patient.DataListPacient;
import com.manzanofp.voli.med.api.patient.DataRegisterPatient;
import com.manzanofp.voli.med.api.patient.Patient;
import com.manzanofp.voli.med.api.patient.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DataListPacient> list (@PageableDefault(page = 0, size = 10, sort = {"nome"})Pageable pageable){
        return patientRepository.findAll(pageable).map(DataListPacient::new);
    }

}
