package com.example.project1602;
/**
* @author Samu Luoma, Miiro Silander, Kim Kari
* apuna käytetty https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText ylapaineDb, alapaineDb, sykeDb, painoDb, merkinnatDb;
    private Button addBtn;
    private MeasurementReadings dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);


        //Perform ItemSelectedListneer
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    return true;
                case R.id.history:
                    startActivity(new Intent(getApplicationContext()
                            ,HistoryActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
        //alustetaan muuttujat
        ylapaineDb = findViewById(R.id.editTextNumberVerenYlaPaine);
        alapaineDb = findViewById(R.id.editTextNumberVerenAliPaine);
        sykeDb = findViewById(R.id.editTextNumberSyke);
        painoDb = findViewById(R.id.editTextNumberPaino);
        addBtn = findViewById(R.id.buttonTallenna);


        TextView AikaTextView = findViewById(R.id.textViewAika);
        //hakee päivämäärän ja ajan kalenterista,   "pattern" miten halutaan ajan tulevan näkyvin
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy     HH:mm", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        AikaTextView.setText(currentTime);

        // luodaan uusi measurementreadings luokka
        //
        dbHandler = new MeasurementReadings(MainActivity.this);
        // luodaan click listener napille
        addBtn.setOnClickListener(v -> {

            // haetaan data edittext kentistä
            String ylapaine = ylapaineDb.getText().toString();
            String alapaine = alapaineDb.getText().toString();
            String syke = sykeDb.getText().toString();
            String paino = painoDb.getText().toString();
            String aika = currentTime;

            // validoidaan edittext kentät (paino vapaaehtoinen)
            if (ylapaine.isEmpty() || Integer.parseInt(ylapaine) > 300){
                Toast.makeText(MainActivity.this, "Tarkista yläpaine kenttä", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (alapaine.isEmpty() || Integer.parseInt(alapaine) > 300){
                Toast.makeText(MainActivity.this, "Tarkista alapaine kenttä", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (syke.isEmpty() || Integer.parseInt(syke) > 300){
                Toast.makeText(MainActivity.this, "Tarkista syke kenttä", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (!paino.isEmpty()){
                if(Integer.parseInt(paino) > 300) {
                    Toast.makeText(MainActivity.this, "Tarkista paino kenttä", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            //luodaan uusi metodi jolle syötetään arvot
            dbHandler.addNewNote(ylapaine, alapaine, syke, paino, aika);

            // näyttään toast viesti käyttäjälle
            Toast.makeText(MainActivity.this, "Uusi merkintä lisätty", Toast.LENGTH_SHORT).show();
            ylapaineDb.setText("");
            alapaineDb.setText("");
            sykeDb.setText("");
            painoDb.setText("");

        });
    }
}
