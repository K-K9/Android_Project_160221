package com.example.project1602;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;



import android.widget.TextView;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class MittausTulokset extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mittaus_tulokset);



        TextView AikaTextView = findViewById(R.id.textViewAika);
        //hakee päivämäärän ja ajan kalenterista,   "pattern" miten halutaan ajan tulevan näkyvin
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy     HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        AikaTextView.setText(currentTime);


    }





}