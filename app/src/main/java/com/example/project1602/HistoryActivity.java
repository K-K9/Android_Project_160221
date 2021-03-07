package com.example.project1602;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class HistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Initialize and assign variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.history);


        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.summary:
                    startActivity(new Intent(getApplicationContext()
                            ,SummaryActivity.class));
                    overridePendingTransition(0,0);
                    return true;
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


        //kutsu filtteröintiin
        initSearchWidgets();

    }


    //listview tarvitsee ehkä muokkausta bottomnavin ja haku kentän suhteen?? kunhan saadaan testattua.
    //filtteröinti käyttäjän kirjoituksen mukaan, muokkausta sen mukaan mistä haetaan tallennettu tieto.
    private void initSearchWidgets()
    {
        SearchView searchView = (SearchView) findViewById(R.id.ListSearchViewMeasurement);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }


           //filtteriöinti kun käyttäjä kirjoittaa tekstikenttään
           @Override
           public boolean onQueryTextChange(String newText) {

               //muokkausta tähän pätkään, haetaan tallennetut tulokset muistista ja filtteröidään päivämäärän mukaan?
               /*ArrayList<Shape> filteredShapes = new ArrayList<Shape>();
               for(shape shape: shapeList){
                   if(shape.getDate().toLowerCase().contains(s.toLowerCaser())){
                       filteredShape.add(shape);
                   }

               }
                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
               listview.setAdapter(adapter);*/


               return false;
           }
       });
    }



}