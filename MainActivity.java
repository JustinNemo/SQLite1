package com.nikolaihost.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup database
        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

        //creating table for users where name is varchar and age is int valued 3
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");

        //inserting data to database
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Justin', 25)");
        myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Louriza', 30)");

        //to pull data from database
        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

        //to access index
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");


        c.moveToFirst();

        while (c != null){

            Log.i("name", c.getString(nameIndex));
            Log.i("age", c.getString(ageIndex));
            c.moveToNext();

        }

    }
}
