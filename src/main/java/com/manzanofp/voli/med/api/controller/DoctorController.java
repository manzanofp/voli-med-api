package com.manzanofp.voli.med.api.controller;

import com.manzanofp.voli.med.api.doctor.DataRegisterDoctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping
    public void register(@RequestBody DataRegisterDoctor data){
        System.out.println(data);
    }

}
