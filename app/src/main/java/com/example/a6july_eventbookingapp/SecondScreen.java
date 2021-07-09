package com.example.a6july_eventbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    private static final String FIRST_NAME = "Name", LAST_NAME = "Surname", EMAIL_ID = "Email",
            PHONE_NO = "Phone", NUMBEROF_SEAT = "No of Seats", DATEOF_SHOW = "DateofShow";
    EditText metNoOfSeat, metDateofShow;
    TextView mtvFirstName, mtvLastName, mtvEmailid;
    Button mbtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        initViews();
        getSharedPrefernceData();
    }

    private void initViews() {
        mtvFirstName = findViewById(R.id.etFirstNames);
        mtvLastName = findViewById(R.id.etsLastName);
        mtvEmailid = findViewById(R.id.etsEmail);
        metNoOfSeat = findViewById(R.id.etsNoOfSeat);
        metDateofShow = findViewById(R.id.etsShowdate);

        mbtnNext = findViewById(R.id.btnsNext);
        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferanceHelper.writeIntoPreferences(SecondScreen.this, NUMBEROF_SEAT, Integer.parseInt(metNoOfSeat.getText().toString()));
                PreferanceHelper.writeStringtoPreferences(SecondScreen.this, DATEOF_SHOW, metDateofShow.getText().toString());

                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                startActivity(intent);
            }
        });
    }

    private void getSharedPrefernceData() {
        String name = PreferanceHelper.getStringfromSharedPrefernces(SecondScreen.this, FIRST_NAME);
        String surname = PreferanceHelper.getStringfromSharedPrefernces(SecondScreen.this, LAST_NAME);
        String email = PreferanceHelper.getStringfromSharedPrefernces(SecondScreen.this, EMAIL_ID);

        mtvFirstName.setText(name);
        mtvLastName.setText(surname);
        mtvEmailid.setText(email);

    }



}