package com.example.plantapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapt extends BaseAdapter {

    Context c;
    ArrayList<Plants> plants;

    public ListAdapt(Context c, ArrayList<Plants> plants) {
        this.c = c;
        this.plants = plants;
    }

    LayoutInflater inflater;

    @Override
    public int getCount() {
        return plants.size();
    }

    @Override
    public Object getItem(int pos) {
        return plants.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        if (inflater == null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.plants_adapt,viewGroup,false);
        }


        TextView txtnm = convertView.findViewById(R.id.txt_plant);

        txtnm.setText(plants.get(pos).getName());


        return convertView;
    }
}
