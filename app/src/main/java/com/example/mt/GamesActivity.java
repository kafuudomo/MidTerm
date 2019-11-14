package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        arrayListGame.add(new Games("Half-Life 2","9.9/10","$20","Half-Life's Description"));
        arrayListGame.add(new Games("CS:GO","8/10","$15","CS:GO's Description"));
        arrayListGame.add(new Games("Fallout 76","2/10","$3","Fallout 76's Description"));

        AdapterActivity adapter = new AdapterActivity(arrayListGame,this);

        listViewGame.setAdapter(adapter);

        listViewGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Games game = (Games)parent.getAdapter().getItem(position);

                    Intent i = new Intent(GamesActivity.this,GameProfileActivity.class);
                    i.putExtra("name", game.getGameName());
                    i.putExtra("rate", game.getGameRate());
                    i.putExtra("price", game.getGamePrice());
                    i.putExtra("description",game.getGameDescription());

                    startActivity(i);

                }
            });

    }

}
