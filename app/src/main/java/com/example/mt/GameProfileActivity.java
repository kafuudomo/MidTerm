package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameProfileActivity extends AppCompatActivity {

    TextView Title,Rate,Price,Description;

    String sTitle, sRate, sPrice, sDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_game_profile);

        sTitle = getIntent().getStringExtra("name");
        sRate = getIntent().getStringExtra("rating");
        sPrice = getIntent().getStringExtra("price");
        sDescription = getIntent().getStringExtra("description");


        Title = findViewById(R.id.tv_Profile_Title);
        Title.setText(sTitle);

        Rate = findViewById(R.id.tv_Profile_rate);
        Rate.setText(sRate);

        Price = findViewById(R.id.tv_Profile_Price);
        Price.setText(sPrice);

        Description = findViewById(R.id.tv_Profile_Description);
        Description.setText(sDescription);

    }


}
