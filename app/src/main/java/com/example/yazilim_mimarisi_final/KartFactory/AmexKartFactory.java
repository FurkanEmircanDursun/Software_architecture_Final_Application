package com.example.yazilim_mimarisi_final.KartFactory;
import com.example.yazilim_mimarisi_final.Kart.Kart;
import com.example.yazilim_mimarisi_final.Kart.Amex;

import java.util.Random;
public class AmexKartFactory extends KartFactory {
    @Override
    public Kart kartYarat(String isim, String soyisim, float kartLimit,float ekPuan) {
        Amex myAmexCard = new Amex();
        String CVV = "";
        String AA;
        Random rastgele = new Random();
        myAmexCard.setIsim(isim);
        myAmexCard.setSoyisim(soyisim);
        myAmexCard.setKartLimiti(kartLimit);
        myAmexCard.setEkPuan(ekPuan);
        // amexCard 4 rakamlı cvv yapımı
        for (int i = 0; i < 4; i++) {
            rastgele.nextInt(10);
            CVV = CVV + rastgele.nextInt(10);}
        myAmexCard.setCVV(CVV);
        // rastgele ay ve yıl verimi
        int ay = rastgele.nextInt(11) + 1;
        if (ay < 10) { AA = "0" + ay; }
        else { AA = "" + ay; }

        int yıl = rastgele.nextInt((77) + 1) + 2022;
        myAmexCard.setSonKullanmaTarihi(AA + "/" + yıl);

        // rastgele kart numarası yaratma
        String kartnumarası = "3";
        // bu döngü kurallara uygun rastgele rakamlar üretiyor
        for (int i = 0; i <= 16; i++) {
            if (i == 0)
                // ilk rakam 3 olmak zorunda ondan işlem yaptırmıyoruz
                continue;
            if (i == 1) {
                // alttaki işlem 0 yada 1 döndürür 0 döndürürse 4 1 döndürürse 7 yazdırır
                int durum = rastgele.nextInt(2);
                if (durum == 0) kartnumarası = kartnumarası + 4;
                if (durum == 1) kartnumarası = kartnumarası + 7;
                continue; }
            if (i == 4 || i == 11) {
                // aralara - ekliyoruz
                kartnumarası = kartnumarası + "-";continue; }
            // rastgeler rakamlar üretiliyor
            kartnumarası = kartnumarası + rastgele.nextInt(10);}
        myAmexCard.setKartNumarası(kartnumarası);
        return myAmexCard; }}
