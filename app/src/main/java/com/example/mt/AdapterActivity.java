package com.example.mt;

import android.content.Context;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.mt.dataModel.Games;

import java.util.ArrayList;

public class AdapterActivity extends ArrayAdapter<Games> {

    private ArrayList<Games> dataset;
    private Context context;

    private static class ViewHolder{
        TextView Name;
        TextView Rate;
        TextView Price;
    }

    public AdapterActivity(ArrayList<Games> data, Context context){

        super (context,R.layout.activity_adapter,data);
        this.dataset = data;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Games game = getItem(position);

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_adapter,parent,false);

            holder.Name = convertView.findViewById(R.id.tvName);
            holder.Rate = convertView.findViewById(R.id.tvRate);
            holder.Price = convertView.findViewById(R.id.tvPrice);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.Name.setText(game.getGameName());
        holder.Rate.setText(game.getGameRate());
        holder.Price.setText(game.getGamePrice());

        return convertView;
    }
}
