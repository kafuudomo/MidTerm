package com.example.mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameProfileActivity extends AppCompatActivity {

    String TITLE ="[t]", RATE="[r]", PRICE="[p]", DES="[d]";

    TextView tvTitle,tvRate,tvPrice,tvDescription;

    String Title, Rate, Price, Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_profile);

        Title = getIntent().getStringExtra("name");
        Rate = getIntent().getStringExtra("rate");
        Price = getIntent().getStringExtra("price");
        Description = getIntent().getStringExtra("description");

        replace();

        tvTitle = findViewById(R.id.tv_Profile_Title);
        tvTitle.setText(TITLE);
        tvRate = findViewById(R.id.tv_Profile_rate);
        tvRate.setText(RATE);
        tvPrice = findViewById(R.id.tv_Profile_Price);
        tvPrice.setText(PRICE);
        tvDescription = findViewById(R.id.tv_Profile_Description);
        tvDescription.setText(DES);

    }

    private void replace(){
        TITLE = TITLE.replace("[t]",Title);
        RATE = RATE.replace("[r]",Rate);
        PRICE = PRICE.replace("[p]",Price);
        DES = DES.replace("[d]",Description);

    }

//    private void JSON (){
//        String url = "https://api.myjson.com/bins/16yq7a";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray JsonArray = response.getJSONArray("Game");
//
//                    JSONObject game1 = JsonArray.getJSONObject(0);
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//    }
}
