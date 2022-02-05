package com.example.yazilim_mimarisi_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yazilim_mimarisi_final.Kart.Amex;
import com.example.yazilim_mimarisi_final.Kart.MasterCard;
import com.example.yazilim_mimarisi_final.Kart.Visa;
import com.example.yazilim_mimarisi_final.KartFactory.AmexKartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.KartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.MasterCardKartFactory;
import com.example.yazilim_mimarisi_final.KartFactory.VisaKartFactory;

public class MainActivity extends AppCompatActivity {
    EditText adText;
    EditText soyadText;
    EditText krediLimitText;
    EditText ekPuanText;

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adText=findViewById(R.id.editTextAd);
        soyadText=findViewById(R.id.ediTextSoyad);
        krediLimitText=findViewById(R.id.editTextKartLimit);
        ekPuanText=findViewById(R.id.editTextEkPuan);
        spinner=findViewById(R.id.spinner);

    }
    public void Button(View view){
        if(adText.getText().toString().isEmpty()||soyadText.getText().toString().isEmpty()||krediLimitText.getText().toString().isEmpty()||ekPuanText.getText().toString().isEmpty()){
        }
        else{
            Intent intent = new Intent(this, KartActivity.class);
            intent.putExtra("ad",adText.getText().toString());
            intent.putExtra("soyad",soyadText.getText().toString());
            intent.putExtra("krediLimiti",krediLimitText.getText().toString());
            intent.putExtra("kartTuru",spinner.getSelectedItem().toString());
            intent.putExtra("ekPuan",ekPuanText.getText().toString());
            startActivity(intent);
        }
    }
}