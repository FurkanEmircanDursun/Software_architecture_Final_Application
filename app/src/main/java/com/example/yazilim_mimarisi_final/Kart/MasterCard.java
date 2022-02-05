package com.example.yazilim_mimarisi_final.Kart;

public class MasterCard extends Kart {
    public void paraHarca(float tutar) {

        setKartLimiti(getKartLimiti()-tutar);
    }

    @Override
    public void borcOde(float tutar) {

        setKartLimiti(getKartLimiti()+tutar);

    };
}
