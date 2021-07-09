package com.example.a6july_eventbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String FIRST_NAME = "Name", LAST_NAME = "Surname", EMAIL_ID = "Email", PHONE_NO = "Phone";
    EditText metFirstname, metLastname, metEmail, metPhone;
    Button mbtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        metFirstname = findViewById(R.id.etFirstName);
        metLastname = findViewById(R.id.etLastName);
        metEmail = findViewById(R.id.etEmail);
        metPhone = findViewById(R.id.etPhone);

        mbtnNext = findViewById(R.id.btnSubmit);
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferanceHelper.writeStringtoPreferences(MainActivity.this, FIRST_NAME, metFirstname.getText().toString());
                PreferanceHelper.writeStringtoPreferences(MainActivity.this, LAST_NAME, metLastname.getText().toString());
                PreferanceHelper.writeStringtoPreferences(MainActivity.this, EMAIL_ID, metEmail.getText().toString());
                PreferanceHelper.writeIntoPreferences(MainActivity.this, PHONE_NO, Integer.parseInt(metPhone.getText().toString()));

                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                startActivity(intent);
            }
        });
    }
}