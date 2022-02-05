package com.example.yazilim_mimarisi_final.KartFactory;
import com.example.yazilim_mimarisi_final.Kart.Kart;
import com.example.yazilim_mimarisi_final.Kart.MasterCard;

import java.util.Random;
public class MasterCardKartFactory extends KartFactory{
    @Override
    public Kart kartYarat(String isim,String soyisim,float kartLimit,float ekPuan) {
        MasterCard myMasterCard=new MasterCard();
        String CVV="";
        String AA;
        Random rastgele = new Random();
        myMasterCard.setIsim(isim);
        myMasterCard.setSoyisim(soyisim);
        myMasterCard.setKartLimiti(kartLimit);
        myMasterCard.setEkPuan(ekPuan);
        // mastercard 3 rakamlı cvv yapımı
        for(int i =0;i<3;i++){
            rastgele.nextInt(10);
            CVV=CVV+rastgele.nextInt(10);
        }
        myMasterCard.setCVV(CVV);
        // rastgele ay ve yıl verimi
        int ay =rastgele.nextInt(11)+1;
        if(ay<10){ AA="0"+ay; }
        else{ AA =""+ay; }
        int yıl=rastgele.nextInt((77)+1)+2022;
        myMasterCard.setSonKullanmaTarihi(AA+"/"+yıl);
        // rastgele kart numarası yaratma
        String kartnumarası="5";
        // bu döngü kurallara uygun rastgele rakamlar üretiyor
        for(int i=0; i<=17;i++){
            if (i == 0)
                // ilk hane 5 olmak zorunda
                continue;
            if(i==1){
                //kartın 2. hanesi için 1 ile 5 arası rakam üretir
                kartnumarası=kartnumarası+rastgele.nextInt(5)+1;
                continue;
            }
            if(i==3||i==8||i==13){
                //aralara - koyuyoruz
                kartnumarası=kartnumarası+"-";
                continue; }
            // rastgeler rakamlar üretiliyor
            kartnumarası=kartnumarası+rastgele.nextInt(10); }
           myMasterCard.setKartNumarası(kartnumarası);
           return myMasterCard; }}
