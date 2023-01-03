package com.manzanofp.voli.med.api.entities.patient;

import com.manzanofp.voli.med.api.entities.adress.Address;
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

    private Boolean active;

    public Patient(DataRegisterPatient data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.cellphone = data.cellphone();
        this.address = new Address(data.address());
    }

    public void updateInfo(DataUpdatePatient data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.email() != null){
            this.cellphone = data.email();
        }
        if (data.address() != null){
            this.address.updateAdressInfo(data.address());
        }
        if (data.cpf() != null){
            this.cpf = data.cpf();
        }
        if (data.cellphone() != null){
            this.cellphone = data.cellphone();
        }
    }

    public void  delete(){
        this.active = false;
    }

}
