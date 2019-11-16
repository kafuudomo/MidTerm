package com.example.mt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.mt.dataModel.Games;
import com.example.mt.parser.JSONParser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;



public class GamesActivity extends AppCompatActivity {

    private ListView listViewGame;
    private ArrayList<Games> arrayListGame = new ArrayList<>();
    private AdapterActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_games);

        listViewGame = findViewById(R.id.listViewGame);
        new GetDataTask().execute();

        adapter = new AdapterActivity(arrayListGame, this);
        listViewGame.setAdapter(adapter);
        listViewGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = (Games) parent.getAdapter().getItem(position);

                Intent i = new Intent(GamesActivity.this, GameProfileActivity.class);
                i.putExtra("name", games.getGameName());
                i.putExtra("rating", games.getGameRate());
                i.putExtra("price", games.getGamePrice());
                i.putExtra("description",games.getGameDescription());

                startActivity(i);
            }
        });

    }

    /**
     * Creating Get Data Task for Getting Data From Web
     */
    class GetDataTask extends AsyncTask<Void, Void, Void> {

//        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Nullable
        @Override
        protected Void doInBackground(Void... params) {


            JSONObject jsonObject = JSONParser.getDataFromWeb();

            try {

                if (jsonObject != null) {

                    if(jsonObject.length() > 0) {

                        JSONArray array = jsonObject.getJSONArray("data");


                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for(int jIndex = 0; jIndex < lenArray; jIndex++) {

                                Games games = new Games();


                                JSONObject game = array.getJSONObject(jIndex);
                                String name = game.getString("name");
                                String rate = game.getString("rating");
                                String price = game.getString("price");
                                String DES = game.getString("description");

                                games.setGameName(name);
                                games.setGameRate(rate);
                                games.setGamePrice(price);
                                games.setGameDescription(DES);


                                arrayListGame.add(games);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONParser.TAG, "" + je.getLocalizedMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            dialog.dismiss();

            if(arrayListGame.size() > 0) {
                adapter.notifyDataSetChanged();
            }
        }
    }

}
