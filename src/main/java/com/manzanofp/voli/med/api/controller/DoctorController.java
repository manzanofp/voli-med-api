package com.manzanofp.voli.med.api.controller;

import com.manzanofp.voli.med.api.doctor.DataRegisterDoctor;
import com.manzanofp.voli.med.api.doctor.Doctor;
import com.manzanofp.voli.med.api.doctor.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody DataRegisterDoctor data){
    doctorRepository.save(new Doctor(data));
    }

}
