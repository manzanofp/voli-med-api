package com.manzanofp.voli.med.api.controller;

import com.manzanofp.voli.med.api.doctor.DataListDoctor;
import com.manzanofp.voli.med.api.doctor.DataRegisterDoctor;
import com.manzanofp.voli.med.api.doctor.Doctor;
import com.manzanofp.voli.med.api.doctor.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterDoctor data){
    doctorRepository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DataListDoctor> list(Pageable pageable){
    return  doctorRepository.findAll(pageable).map(DataListDoctor::new);
    }



}
