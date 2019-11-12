package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mt.dataModel.Games;

import java.util.ArrayList;

public class GamesActivity extends AppCompatActivity {

    private ListView listViewGame;
    private ArrayList<Games> arrayListGame = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_games);

        listViewGame = findViewById(R.id.listViewGame);

        arrayListGame.add(new Games("Half-Life 2","9.9/10","$20"));
        arrayListGame.add(new Games("CS:GO","8/10","$15"));
        arrayListGame.add(new Games("Fallout 76","2/10","$3"));

        AdapterActivity adapter = new AdapterActivity(arrayListGame,this);

        listViewGame.setAdapter(adapter);



    }
}
