package com.example.a6july_eventbookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdScreen extends AppCompatActivity {

    private static final String FIRST_NAME = "Name", LAST_NAME = "Surname", EMAIL_ID = "Email",
            PHONE_NO = "Phone", NUMBEROF_SEAT = "No of Seats", DATEOF_SHOW = "DateofShow";
    private TextView mtvFirstName, mtvLastName, mtvEmailid, mtvNoOfSeat, mtvDateofShow;
    private Button mbtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);
        initViews();
        getSharedPreferenceData();

    }

    private void getSharedPreferenceData() {
        String name = PreferanceHelper.getStringfromSharedPrefernces(ThirdScreen.this,FIRST_NAME);
        String surname = PreferanceHelper.getStringfromSharedPrefernces(ThirdScreen.this,LAST_NAME);
        String email = PreferanceHelper.getStringfromSharedPrefernces(ThirdScreen.this,EMAIL_ID);
        //int phone = PreferanceHelper.getIntfromSharedPrefernces(ThirdScreen.this,PHONE_NO);
        int noOfSeat = PreferanceHelper.getIntfromSharedPrefernces(ThirdScreen.this,NUMBEROF_SEAT);
        String dateOfShow = PreferanceHelper.getStringfromSharedPrefernces(ThirdScreen.this,DATEOF_SHOW);

        mtvFirstName.setText(name);
        mtvLastName.setText(surname);
        mtvNoOfSeat.setText(noOfSeat+"");
        mtvDateofShow.setText(dateOfShow);
        mtvEmailid.setText(email);


    }

    private void initViews() {
        mtvFirstName = findViewById(R.id.ettFirstName);
        mtvLastName = findViewById(R.id.ettLastName);
        mtvEmailid = findViewById(R.id.ettEmail);
        mtvDateofShow = findViewById(R.id.ettShowdate);
        mtvNoOfSeat = findViewById(R.id.ettNoOfSeat);
        mbtConfirm = findViewById(R.id.btnConfirm);

        mbtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ThirdScreen.this)
                        .setTitle("Confirmation")
                        .setMessage("The event is confirmed on " + mtvDateofShow.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();

            }
        });

    }
}