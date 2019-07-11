package com.example.plantapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
     ImageView img;
     TextView txt;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String link = getResources().getString(R.string.link);

        img=findViewById(R.id.img);
        txt=findViewById(R.id.txt);


        Httphandler hp = new Httphandler();

        String json = hp.makeService(link);

        System.out.println("Main Activity :"+json);

        /*ObjectAnimator animator = ObjectAnimator.ofFloat(img,"rotationY",0.0f,360.0f);
        animator.setDuration(3000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent=new Intent(MainActivity.this,ListActivity.class);
                //startActivity(intent);
                finish();
            }
        },5000);*/

    }
}