package com.manzanofp.voli.med.api.controller;

import com.manzanofp.voli.med.api.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterDoctor data, UriComponentsBuilder uriBuilder){
    var doctor = new Doctor(data);
    doctorRepository.save(doctor);
    var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
    return ResponseEntity.created(uri).body(new DataDoctorDetail(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DataListDoctor>> list(Pageable pageable){
    var page = doctorRepository.findAllByActiveTrue(pageable).map(DataListDoctor::new);
    return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctor data){
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateInfo(data);
        return ResponseEntity.ok(new DataDoctorDetail(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
   public ResponseEntity<?> delete(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
   }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataDoctorDetail(doctor));
    }

}
