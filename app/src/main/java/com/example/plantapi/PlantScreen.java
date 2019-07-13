package com.example.plantapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class PlantScreen extends AppCompatActivity {

    ArrayList<Plants> pro;
    ListView lstv;

    ListAdapt adapt;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plants);

        pro = new ArrayList<>();

        String link = getResources().getString(R.string.link);

        try {
            String myjson = new Syncdata().execute(link).get();
            System.out.println("Main Activity :"+myjson);

            //JSONArray plants = new JSONArray(myjson);

          /*
            for(int i=0;i<plants.length();i++){
                JSONObject childObj = plants.getJSONObject(i);
                System.out.println("Main Activity1 :"+childObj);

                String name = childObj.getString("scientific_name");

                System.out.println("Main Activity2: "+name);

                pro.add(new Plants(name));

            }*/



            adapt = new ListAdapt(getApplicationContext(),pro);

            lstv.setAdapter(adapt);



            /*lstv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(MainActivity.this,Prodactdesc.class);

                    i.putExtra("data",pro.get(position));
                    startActivity(i);

                }
            });

            }*/


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
