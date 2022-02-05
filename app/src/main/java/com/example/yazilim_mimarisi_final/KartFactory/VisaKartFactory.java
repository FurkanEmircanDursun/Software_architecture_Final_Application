package com.example.yazilim_mimarisi_final.KartFactory;
import com.example.yazilim_mimarisi_final.Kart.Kart;
import com.example.yazilim_mimarisi_final.Kart.Visa;

import java.util.Random;
public class VisaKartFactory  extends  KartFactory{
    @Override
    public Kart kartYarat(String isim, String soyisim, float kartLimit,float ekPuan) {
        Visa myVisaCard=new Visa();
        String CVV="";
        String AA;
        Random rastgele = new Random();
        myVisaCard.setIsim(isim);
        myVisaCard.setSoyisim(soyisim);
        myVisaCard.setKartLimiti(kartLimit);
        myVisaCard.setEkPuan(ekPuan);
        // visacard 3 rakamlı cvv yapımı
        for(int i =0;i<3;i++){

            rastgele.nextInt(10);
            CVV=CVV+rastgele.nextInt(10); }
        myVisaCard.setCVV(CVV);
        // rastgele ay ve yıl verimi
        int ay =rastgele.nextInt(11)+1;
        if(ay<10){ AA="0"+ay; }
        else{ AA =""+ay;}
        int yıl=rastgele.nextInt((77)+1)+2022;
        myVisaCard.setSonKullanmaTarihi(AA+"/"+yıl);

        // rastgele kart numarası yaratma
        String kartnumarası="4";
        // bu döngü kurallara uygun rastgele rakamlar üretiyor
        for(int i=0; i<=18;i++){
            if (i == 0)
                // ilk rakam 4 olmak zorunda ondan işlem yaptırmıyoruz
                continue;

            if(i==4||i==9||i==14){
                // aralara - ekliyoruz
                kartnumarası=kartnumarası+"-";
                continue;
            }
            // rastgeler rakamlar üretiliyor
            kartnumarası=kartnumarası+rastgele.nextInt(10);

        }
        myVisaCard.setKartNumarası(kartnumarası);
return myVisaCard;
    }}
