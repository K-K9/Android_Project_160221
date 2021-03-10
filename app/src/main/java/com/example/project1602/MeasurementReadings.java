package com.example.project1602;
/**
* @author Samu Luoma, Miiro Silander
* apuna käytetty https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
*/
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeasurementReadings extends SQLiteOpenHelper {

    //constant muuttujat tietokannalle
    // nimi tietokannalle
    private static final String DB_NAME = "bloodpressure.db";

    // tietokannan versio
    private static final int DB_VERSION = 1;

    // muuttuja taulun nimelle
    private static final String TABLE_NAME = "merkinnat";

    // uniikki id
    private static final String ID_COL = "id";


    private static final String YLAPAINE_COL = "ylapaine";


    private static final String ALAPAINE_COL = "alapaine";


    private static final String SYKE_COL = "syke";


    private static final String PAINO_COL = "paino";

    private static final String NOTES_COL = "merkinnat";

    private static final String AIKA_COL = "aika";

    // luodaan konstruktori tietokannan käsittelijälle
    public MeasurementReadings(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //sqlite query jolla luodaan database
    @Override
    public void onCreate(SQLiteDatabase db) {
        // nimetään sqlite tietokantaan muuttujat
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + YLAPAINE_COL + " TEXT,"
                + ALAPAINE_COL + " TEXT,"
                + SYKE_COL + " TEXT,"
                + PAINO_COL + " TEXT,"
                + NOTES_COL + " TEXT,"
                + AIKA_COL + " TEXT)";

        // suoritetaan query
        db.execSQL(query);
    }



    /**
     * luodaan uusi merkintä tietokantaan
     * @param ylapaine
     * @param alapaine
     * @param syke
     * @param paino
     * @param aika
     */
    public void addNewNote(String ylapaine, String alapaine, String syke, String paino, String aika) {

        // luodaan muuttuja SQLitelle
        //tehdään siitä Writeable jotta voidaan
        // kirjoittaa tietokantaan
        SQLiteDatabase db = this.getWritableDatabase();

        // luodaan ContentValues muuttuja
        ContentValues values = new ContentValues();

        // siirretään key-value arvot
        values.put(YLAPAINE_COL, ylapaine);
        values.put(ALAPAINE_COL, alapaine);
        values.put(SYKE_COL, syke);
        values.put(PAINO_COL, paino);
        values.put(AIKA_COL, aika);

        // siirretään contentvalues arvo
        db.insert(TABLE_NAME, null, values);

        // suljetaan database
        db.close();
    }

    /**
     * Haetaan dataa tietokannasta
     * @return
     */
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // tarkistetaan onko database jo olemassa
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }
}
