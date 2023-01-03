package com.manzanofp.voli.med.api.entities.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String place;
    private String district;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(DataAddress data) {
        this.place = data.place();
        this.district = data.district();
        this.cep = data.cep();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.number = data.number();
    }

    public void updateAdressInfo(DataAddress data) {
        if (data.place() != null){
            this.place = data.place();
        }
        if (data.district() != null){
            this.district = data.district();
        }
        if (data.cep() != null){
            this.cep = data.cep();
        }
        if (data.city() != null){
            this.city = data.city();
        }
        if (data.uf() != null){
            this.uf = data.uf();
        }
        if (data.complement() != null){
            this.complement = data.complement();
        }
        if (data.number() != null){
            this.number = data.number();
        }

    }
}
