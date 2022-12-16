package com.manzanofp.voli.med.api.doctor;


import com.manzanofp.voli.med.api.adress.Address;
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
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    public Doctor(DataRegisterDoctor data) {
        this.name = data.name();
        this.crm = data.crm();
        this.email = data.email();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }
}
