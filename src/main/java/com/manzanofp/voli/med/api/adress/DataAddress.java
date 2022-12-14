package com.manzanofp.voli.med.api.adress;

public record DataAddress(String place,
                         String district,
                         String cep,
                         String city,
                         String uf,
                         String complement,
                         String number) {
}
