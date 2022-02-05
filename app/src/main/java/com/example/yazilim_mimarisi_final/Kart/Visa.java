package com.example.yazilim_mimarisi_final.Kart;

public class Visa extends  Kart{

    @Override
    public void paraHarca(float tutar) {

        setKartLimiti(getKartLimiti()-tutar);

    }

    @Override
    public void borcOde(float tutar) {

        setKartLimiti(getKartLimiti()+tutar);
    };

}
