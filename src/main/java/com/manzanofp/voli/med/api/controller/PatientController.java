package com.manzanofp.voli.med.api.controller;


import com.manzanofp.voli.med.api.patient.dataRegisterPatient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @PostMapping
    public void register (@RequestBody dataRegisterPatient data){
        System.out.println(data);
    }


}
