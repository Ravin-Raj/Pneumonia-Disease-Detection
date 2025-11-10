package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView cardPredict = findViewById(R.id.card_predict);

        // Set click listeners for each CardView
        cardPredict.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ImageInputActivity.class);
            startActivity(intent);
        });
    }
}