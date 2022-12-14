package com.manzanofp.voli.med.api.Controller;

import com.manzanofp.voli.med.api.doctor.dataRegisterDoctor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping
    public void register(@RequestBody dataRegisterDoctor data){
        System.out.println(data);
    }

}
