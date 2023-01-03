package com.manzanofp.voli.med.api.controller;


import com.manzanofp.voli.med.api.entities.patient.DataListPacient;
import com.manzanofp.voli.med.api.entities.patient.Patient;
import com.manzanofp.voli.med.api.entities.patient.PatientRepository;
import com.manzanofp.voli.med.api.entities.patient.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> register (@RequestBody @Valid DataRegisterPatient data, UriComponentsBuilder uriBuilder){
       var patient = new Patient(data);
       patientRepository.save(patient);
        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataPatientDetail(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataListPacient>> list (@PageableDefault(page = 0, size = 10, sort = {"name"})Pageable pageable){
        var page = patientRepository.findAllByActiveTrue(pageable).map(DataListPacient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> update (@RequestBody @Valid DataUpdatePatient data){
        var patient = patientRepository.getReferenceById(data.id());
        patient.updateInfo(data);
        return ResponseEntity.ok(new DataPatientDetail(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var patient = patientRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataPatientDetail(patient));
    }
}
