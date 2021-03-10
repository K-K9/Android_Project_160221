package com.example.project1602;
/**
* Tämän luokan avulla Merkinnät-tabissa saadaan näytettyä SQLite-tietokannasta tuotu data ja luotua siitä dynaaminen lista
* @author Samu Luoma
* apuna käytetty https://www.youtube.com/watch?v=VQKq9RHMS_0
*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {
    MeasurementReadings db;
    ArrayList<String> alapaine_id, ylapaine_id, syke_id, paino_id, aika_id;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Alusta ja aseta muuttujat
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Historia näkymänä
        bottomNavigationView.setSelectedItemId(R.id.history);


        //Siirtymiset toisiin näkymiin
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            ,MainActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.history:
                    return true;
            }
            return false;
        });
        recyclerView = findViewById(R.id.recyclerView);
        db = new MeasurementReadings(HistoryActivity.this);
        alapaine_id = new ArrayList<>();
        ylapaine_id = new ArrayList<>();
        syke_id = new ArrayList<>();
        paino_id = new ArrayList<>();
        aika_id = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(HistoryActivity.this, ylapaine_id, alapaine_id, syke_id, paino_id, aika_id);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        }
        void storeDataInArrays(){
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Ei merkintöjä", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                ylapaine_id.add(cursor.getString(1));
                alapaine_id.add(cursor.getString(2));
                syke_id.add(cursor.getString(3));
                paino_id.add(cursor.getString(4));
                aika_id.add(cursor.getString(6));

            }
        }

    }





}
