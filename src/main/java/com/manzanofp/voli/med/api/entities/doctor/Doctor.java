package com.manzanofp.voli.med.api.entities.doctor;


import com.manzanofp.voli.med.api.entities.adress.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private Boolean active;

    public Doctor(DataRegisterDoctor data) {
        this.active = true;
        this.name = data.name();
        this.crm = data.crm();
        this.email = data.email();
        this.cellphone = data.cellphone();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateInfo(DataUpdateDoctor data) {
       if (data.name() != null){
           this.name = data.name();
       }
        if (data.cellphone() != null){
            this.cellphone = data.cellphone();
        }
        if (data.address() != null){
            this.address.updateAdressInfo(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
