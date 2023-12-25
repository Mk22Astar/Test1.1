package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

//    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
//        txtUser = (TextView) findViewById(R.id.textUser);

    }

//    Cursor cursor = database.query()
    public void btnClik(View v){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }
    public void btnClik2(View v){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void btnClik3(View v){
        Uri number = Uri.parse("tel:85654625");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }


}