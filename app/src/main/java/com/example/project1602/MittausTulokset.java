package com.example.project1602;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;



import android.widget.TextView;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class MittausTulokset extends AppCompatActivity {
    private EditText ylapaineDb, alapaineDb, sykeDb, painoDb, merkinnatDb;
    private Button addBtn;
    private MeasurementReadings dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mittaus_tulokset);
        //alustetaan muuttujat
        ylapaineDb = findViewById(R.id.editTextNumberVerenYlaPaine);
        alapaineDb = findViewById(R.id.editTextNumberVerenAliPaine);
        sykeDb = findViewById(R.id.editTextNumberSyke);
        painoDb = findViewById(R.id.editTextNumberPaino);
        merkinnatDb = findViewById(R.id.editTextTextKomentti);
        addBtn = findViewById(R.id.buttonTallenna);


        TextView AikaTextView = findViewById(R.id.textViewAika);
        //hakee päivämäärän ja ajan kalenterista,   "pattern" miten halutaan ajan tulevan näkyvin
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy     HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        AikaTextView.setText(currentTime);

        // luodaan uusi measurementreadings luokka
        //
        dbHandler = new MeasurementReadings(MittausTulokset.this);
        // below line is to add on click listener for our add course button.
        addBtn.setOnClickListener(v -> {

            // below line is to get data from all edit text fields.
            String ylapaine = ylapaineDb.getText().toString();
            String alapaine = alapaineDb.getText().toString();
            String syke = sykeDb.getText().toString();
            String paino = painoDb.getText().toString();
            String merkinnat = merkinnatDb.getText().toString();
            String aika = currentTime;

            // validating if the text fields are empty or not.
            if (ylapaine.isEmpty() && alapaine.isEmpty() && syke.isEmpty()) {
                Toast.makeText(MittausTulokset.this, "Syötäthän ylapaineen, alapaineen ja sykkeen", Toast.LENGTH_SHORT).show();
                return;
            }

            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            dbHandler.addNewNote(ylapaine, alapaine, syke, paino, merkinnat, aika);

            // after adding the data we are displaying a toast message.
            Toast.makeText(MittausTulokset.this, "Uusi päiväkirja merkintä lisätty", Toast.LENGTH_SHORT).show();
            ylapaineDb.setText("");
            alapaineDb.setText("");
            sykeDb.setText("");
            painoDb.setText("");
            merkinnatDb.setText("");

        });
    }





}