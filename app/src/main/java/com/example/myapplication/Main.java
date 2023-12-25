package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnAdd = (Button) findViewById(R.id.button);

        btnRead = (Button) findViewById(R.id.button1);


        btnClear = (Button) findViewById(R.id.button2);


        etName = (EditText) findViewById(R.id.email);
        etEmail = (EditText) findViewById(R.id.password);

        dbHelper = new DBHelper(this);

    }


    @SuppressLint("NonConstantResourceId")
    public void btnClik(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        MenuItem menuItem = null;
        int id = menuItem.getItemId();
            if(id == R.id.button) {

                contentValues.put(DBHelper.KEY_NAME, email);
                contentValues.put(DBHelper.KEY_MAIL, name);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                return;
            }

            else if(id == R.id.button1) {
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog", "0 rows");

                cursor.close();
            }
            else{

                database.delete(DBHelper.TABLE_CONTACTS, null, null);

        }
        dbHelper.close();
    }

}
