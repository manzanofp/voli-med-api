package com.manzanofp.voli.med.api.controller;

import com.manzanofp.voli.med.api.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterDoctor data){
    doctorRepository.save(new Doctor(data));
    return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public Page<DataListDoctor> list(Pageable pageable){
    return  doctorRepository.findAll(pageable).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateDoctor data){
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateInfo(data);

    }

}
