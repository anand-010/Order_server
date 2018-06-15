package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anand on 6/15/2018.
 */

public class orderactivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> names = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemsmanagement);
        names.add("anand");
        names.add("anand");
        names.add("anand");
        names.add("anand");
        recyclerView = (RecyclerView)findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mAdapter = new orderpageadapter(names);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }
}
