package com.example.project1602;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button moveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moveBtn = findViewById(R.id.siirryBtn);

        moveBtn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext()
                    ,MittausTulokset.class));
            overridePendingTransition(0,0);
        });
        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);


        //Perform ItemSelectedListneer
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.summary:
                    startActivity(new Intent(getApplicationContext()
                    ,SummaryActivity.class));
                    overridePendingTransition(0,0);
                    return true;
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
    }
}