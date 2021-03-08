package com.example.project1602;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeasurementReadings extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "bloodpressure.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "merkinnat";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String YLAPAINE_COL = "ylapaine";

    // below variable id for our course duration column.
    private static final String ALAPAINE_COL = "alapaine";

    // below variable for our course description column.
    private static final String SYKE_COL = "syke";

    // below variable is for our course tracks column.
    private static final String PAINO_COL = "paino";

    private static final String NOTES_COL = "merkinnat";

    private static final String AIKA_COL = "aika";

    // creating a constructor for our database handler.
    public MeasurementReadings(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + YLAPAINE_COL + " TEXT,"
                + ALAPAINE_COL + " TEXT,"
                + SYKE_COL + " TEXT,"
                + PAINO_COL + " TEXT,"
                + NOTES_COL + " TEXT,"
                + AIKA_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewNote(String ylapaine, String alapaine, String syke, String paino, String merkinnat, String aika) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(YLAPAINE_COL, ylapaine);
        values.put(ALAPAINE_COL, alapaine);
        values.put(SYKE_COL, syke);
        values.put(PAINO_COL, paino);
        values.put(NOTES_COL, merkinnat);
        values.put(AIKA_COL, aika);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }
}
