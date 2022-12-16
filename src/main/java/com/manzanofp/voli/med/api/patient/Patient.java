package com.manzanofp.voli.med.api.patient;

import com.manzanofp.voli.med.api.adress.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patient")
@Table(name = "patients")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String cellphone;

    @Embedded
    private Address address;

    public Patient(DataRegisterPatient data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.cellphone = data.cellphone();
        this.address = new Address(data.address());
    }

}
