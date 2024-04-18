package com.example.firstapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button statredBttn;
    ImageButton sharedBttn;
    private boolean BtnFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);

        initViews();
        setOnStartBttn();
        setOnShareBttn();
        updateButtonText();
    }

    // Share app Button Action
    private void setOnShareBttn() {
        sharedBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome app: https://play.google.com/store/apps/details?id=");

                startActivity(Intent.createChooser(shareIntent, "Share App via"));
            }
        });

    }

    // for initialize Views on Activity
    private void initViews() {

        statredBttn = findViewById(R.id.ans1);
        sharedBttn = findViewById(R.id.shareBttn);
    }
    // Update button text every 1400 milli Seconds
    private void updateButtonText() {

        final Handler handler = new Handler();;
        handler.post( new Runnable() {
            @Override
            public void run() {
                if (BtnFlag) {
                    statredBttn.setText("Get Started");
                    statredBttn.setTextColor(Color.parseColor("#000000"));
                } else {
                    statredBttn.setText("Click Here");
                    statredBttn.setTextColor(Color.parseColor("#722DC5"));
                }
                BtnFlag = !BtnFlag;
                handler.postDelayed(this, 1400);
            }
        });
    }

    // Action for Started Button
    private void setOnStartBttn() {
        statredBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
    }
}