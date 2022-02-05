package com.example.yazilim_mimarisi_final.KartFactory;

import com.example.yazilim_mimarisi_final.Kart.Kart;

public abstract class KartFactory {

    public abstract Kart kartYarat(String isim,String soyisim,float kartLimit,float ekPuan);
}
