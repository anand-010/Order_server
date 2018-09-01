package com.android.order_ser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by anand on 5/23/2018.
 */

public class mainview extends AppCompatActivity {
    CircleImageView circleImageView,mapview,circleImageView1,list;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmainviewcopy);
        circleImageView=(CircleImageView)findViewById(R.id.history);
        list=(CircleImageView)findViewById(R.id.list);
        circleImageView1=(CircleImageView)findViewById(R.id.prop);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mainview.this,serch.class));


            }
        });
        circleImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mainview.this,orderactivity.class));
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mainview.this,itemmanagementactivity.class));
            }
        });
    }
}
