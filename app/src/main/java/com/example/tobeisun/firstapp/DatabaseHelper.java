package com.example.tobeisun.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by t.obeisun on 2/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "RegistrationDb";
    private static final String TABLE_NAME = "Registration";

    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_NUMBER = "Number";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_USERNAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";
    SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT NOT NULL," + COLUMN_NUMBER + " TEXT NOT NULL," + COLUMN_EMAIL + " TEXT NOT NULL, " + COLUMN_USERNAME + " TEXT NOT NULL," + COLUMN_PASSWORD + " TEXT NOT NULL" + ");";
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertDatabase(Database c)

    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from Registration";

        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_NUMBER, c.getNumber());
        values.put(COLUMN_EMAIL, c.getEmail());

        values.put(COLUMN_USERNAME, c.getUsername());
        values.put(COLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public String searchpass(String uname) {
        db = this.getReadableDatabase();
        String query = "select Username,Password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return b;
    }
}
