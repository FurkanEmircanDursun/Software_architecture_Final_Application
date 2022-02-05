package com.example.yazilim_mimarisi_final.Kart;

public abstract class Kart {

      private String kartNumarası;
      private  String isim;
      private String soyisim;
      private  String sonKullanmaTarihi;
      private String CVV;
      private float kartLimiti;
      private float ekPuan;

      public String getKartNumarası() {
            return kartNumarası;
      }

      public void setKartNumarası(String kartNumarası) {
            this.kartNumarası = kartNumarası;
      }

      public String getIsim() {
            return isim;
      }

      public void setIsim(String isim) {
            this.isim = isim;
      }

      public String getSoyisim() {
            return soyisim;
      }

      public void setSoyisim(String soyisim) {
            this.soyisim = soyisim;
      }

      public String getSonKullanmaTarihi() {
            return sonKullanmaTarihi;
      }

      public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
            this.sonKullanmaTarihi = sonKullanmaTarihi;
      }

      public String getCVV() {
            return CVV;
      }

      public void setCVV(String CVV) {
            this.CVV = CVV;
      }

      public float getKartLimiti() {
            return kartLimiti;
      }

      public void setKartLimiti(float kartLimiti) {
            this.kartLimiti = kartLimiti;
      }

      public float getEkPuan() {
            return ekPuan;
      }

      public void setEkPuan(float ekPuan) {
            this.ekPuan = ekPuan;
      }

      public abstract void paraHarca(float tutar);
      public abstract void borcOde(float tutar);

}
