package com.example.yazilim_mimarisi_final;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yazilim_mimarisi_final.Kart.Amex;
import com.example.yazilim_mimarisi_final.Kart.Kart;
import com.example.yazilim_mimarisi_final.Kart.MasterCard;
import com.example.yazilim_mimarisi_final.Kart.Visa;
import com.example.yazilim_mimarisi_final.KartFactory.AmexKartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.KartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.MasterCardKartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.VisaKartFactory;

import java.util.Locale;
public class KartActivity extends AppCompatActivity {
    TextView adSoyadText;
    TextView kartNumarasiText;
    TextView cvvText;
    TextView sonKullanmaTarihiText;
    TextView kartTuruText;
    EditText miktarText;
    Amex myAmexCard;
    MasterCard myMasterCard;
    Visa myVisaCard;
    TextView oankiKrediLimitText;
    TextView oankiEkPuanText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kart);
        Intent intent = getIntent();
        kartNumarasiText = findViewById(R.id.kartNumarasiText);
        adSoyadText = findViewById(R.id.adSoyadText);
        cvvText = findViewById(R.id.cvvText);
        sonKullanmaTarihiText = findViewById(R.id.sonKullanmaTarihiText);
        kartTuruText = findViewById(R.id.kartTuruText);
        oankiKrediLimitText = findViewById(R.id.oankiKrediLimitText);
        oankiEkPuanText = findViewById(R.id.oankiEkPuanText);

        if (intent.getStringExtra("kartTuru").equals("Visa")) {
            KartFactory mycard = new VisaKartFactory();

            myVisaCard = (Visa) mycard.kartYarat(intent.getStringExtra("ad"), intent.getStringExtra("soyad"), Float.parseFloat(intent.getStringExtra("krediLimiti")), Float.parseFloat(intent.getStringExtra("ekPuan")));
            kartNumarasiText.setText(myVisaCard.getKartNumarası());
            adSoyadText.setText(myVisaCard.getIsim().toUpperCase(Locale.ROOT) + " " + myVisaCard.getSoyisim().toUpperCase(Locale.ROOT));
            cvvText.setText(myVisaCard.getCVV());
            sonKullanmaTarihiText.setText(myVisaCard.getSonKullanmaTarihi());
            kartTuruText.setText(intent.getStringExtra("kartTuru"));
            oankiKrediLimitText.setText("Kart Limiti :" + myVisaCard.getKartLimiti());
            oankiEkPuanText.setText("Ek Puan :" + myVisaCard.getEkPuan());
        } else if (intent.getStringExtra("kartTuru").equals("MasterCard")) {
            KartFactory mycard = new MasterCardKartFactory();

            myMasterCard = (MasterCard) mycard.kartYarat(intent.getStringExtra("ad"), intent.getStringExtra("soyad"), Float.parseFloat(intent.getStringExtra("krediLimiti")), Float.parseFloat(intent.getStringExtra("ekPuan")));
            kartNumarasiText.setText(myMasterCard.getKartNumarası());
            adSoyadText.setText(myMasterCard.getIsim().toUpperCase(Locale.ROOT) + " " + myMasterCard.getSoyisim().toUpperCase(Locale.ROOT));
            cvvText.setText(myMasterCard.getCVV());
            sonKullanmaTarihiText.setText(myMasterCard.getSonKullanmaTarihi());
            kartTuruText.setText(intent.getStringExtra("kartTuru"));
            oankiKrediLimitText.setText("Kart Limiti :" + myMasterCard.getKartLimiti());
            oankiEkPuanText.setText("Ek Puan :" + myMasterCard.getEkPuan());
        } else if (intent.getStringExtra("kartTuru").equals("Amex")) {
            KartFactory mycard = new AmexKartFactory();

            myAmexCard = (Amex) mycard.kartYarat(intent.getStringExtra("ad"), intent.getStringExtra("soyad"), Float.parseFloat(intent.getStringExtra("krediLimiti")), Float.parseFloat(intent.getStringExtra("ekPuan")));
            kartNumarasiText.setText(myAmexCard.getKartNumarası());
            adSoyadText.setText(myAmexCard.getIsim().toUpperCase(Locale.ROOT) + " " + myAmexCard.getSoyisim().toUpperCase(Locale.ROOT));
            cvvText.setText(myAmexCard.getCVV());
            sonKullanmaTarihiText.setText(myAmexCard.getSonKullanmaTarihi());
            kartTuruText.setText(intent.getStringExtra("kartTuru"));
            oankiEkPuanText.setText("Ek Puan :" + myAmexCard.getEkPuan());
            oankiKrediLimitText.setText("Kart Limiti :" + myAmexCard.getKartLimiti()); } }

    public void ParaHarca(View view) {
        miktarText = findViewById(R.id.sayiText);
        if (!miktarText.getText().toString().isEmpty()) {

            Intent intent = getIntent();
            float harcananPara = Float.parseFloat(miktarText.getText().toString());

            if (intent.getStringExtra("kartTuru").equals("Visa")) {

                if (myVisaCard.getKartLimiti() >= harcananPara) {
                    myVisaCard.paraHarca(harcananPara);
                    oankiKrediLimitText.setText("Kart Limiti :" + myVisaCard.getKartLimiti()); } }
            else if (intent.getStringExtra("kartTuru").equals("MasterCard")) {

                if (myMasterCard.getKartLimiti() >= harcananPara) {
                    myMasterCard.paraHarca(harcananPara);
                    oankiKrediLimitText.setText("Kart Limiti :" + myMasterCard.getKartLimiti()); } }
            else if (intent.getStringExtra("kartTuru").equals("Amex")) {

                if (myAmexCard.getKartLimiti() >= harcananPara) {
                    myAmexCard.paraHarca(harcananPara);
                    oankiKrediLimitText.setText("Kart Limiti :" + myAmexCard.getKartLimiti()); } } } }

    public void PuanBorcOde(View view) {
        miktarText = findViewById(R.id.sayiText);
        if (!miktarText.getText().toString().isEmpty()) {

            Intent intent = getIntent();
            float miktar = Float.parseFloat(miktarText.getText().toString());

            if (intent.getStringExtra("kartTuru").equals("Visa")) {

                if (myVisaCard.getEkPuan() >= miktar) {
                    myVisaCard.borcOde(miktar);
                    myVisaCard.setEkPuan(myVisaCard.getEkPuan() - miktar);
                    oankiKrediLimitText.setText("Kart Limiti :" + myVisaCard.getKartLimiti());
                    oankiEkPuanText.setText("Ek Puan :" + myVisaCard.getEkPuan()); } }
            else if (intent.getStringExtra("kartTuru").equals("MasterCard")) {

                if (myMasterCard.getEkPuan() >= miktar) {
                    myMasterCard.borcOde(miktar);
                    myMasterCard.setEkPuan(myMasterCard.getEkPuan() - miktar);
                    oankiKrediLimitText.setText("Kart Limiti :" + myMasterCard.getKartLimiti());
                    oankiEkPuanText.setText("Ek Puan :" + myMasterCard.getEkPuan()); } }
            else if (intent.getStringExtra("kartTuru").equals("Amex")) {
                if (myAmexCard.getEkPuan() >= miktar) {
                    myAmexCard.borcOde(miktar);
                    myAmexCard.setEkPuan(myAmexCard.getEkPuan() - miktar);
                    oankiKrediLimitText.setText("Kart Limiti :" + myAmexCard.getKartLimiti());
                    oankiEkPuanText.setText("Ek Puan :" + myAmexCard.getEkPuan()); } } } }

    public void ParaBorcOde(View view) {
        miktarText = findViewById(R.id.sayiText);
        if (!miktarText.getText().toString().isEmpty()) {
            Intent intent = getIntent();
            float miktar = Float.parseFloat(miktarText.getText().toString());

            if (intent.getStringExtra("kartTuru").equals("Visa")) {
                myVisaCard.borcOde(miktar);
                oankiKrediLimitText.setText("Kart Limiti :" + myVisaCard.getKartLimiti()); }
            else if (intent.getStringExtra("kartTuru").equals("MasterCard")) {
                myMasterCard.borcOde(miktar);
                oankiKrediLimitText.setText("Kart Limiti :" + myMasterCard.getKartLimiti()); }
            else if (intent.getStringExtra("kartTuru").equals("Amex")) {
                myAmexCard.borcOde(miktar);
                oankiKrediLimitText.setText("Kart Limiti :" + myAmexCard.getKartLimiti()); } } }}
