package com.manzanofp.voli.med.api.controller;


import com.manzanofp.voli.med.api.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Page<DataListPacient> list (@PageableDefault(page = 0, size = 10, sort = {"name"})Pageable pageable){
        return patientRepository.findAll(pageable).map(DataListPacient::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> update (@RequestBody @Valid DataUpdatePatient data){
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateInfo(data);
        return new ResponseEntity<>("Update patient!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
        return new ResponseEntity<>("Patient deleted!", HttpStatus.NOT_FOUND);
    }
}
