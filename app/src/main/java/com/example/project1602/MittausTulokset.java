package com.example.project1602;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MittausTulokset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mittaus_tulokset);






        //Päivämäärä ja aika tekstikentät
        TextView AikaTextView = findViewById(R.id.textViewAika);
        TextView PaivamaaraTextView = findViewById(R.id.textViewPaivamaara);
        //asettaa päivämäärän ja ajan tekstikenttiin
        AikaTextView.setText(currentTime);
        PaivamaaraTextView.setText(currentDate);



    }

    //hakee päivämäärän ja ajan kalenterista,   "pattern" miten halutaan ajan tulevan näkyvin
    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());




    /*//buttonille testi siirtyminen mittaustulosten aktiviteettiin
    public void sendMessage(View view){
        Intent intent = new Intent(this, MittausTulokset.class);
        startActivity(intent);
    }*/

}