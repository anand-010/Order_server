package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.order_ser.helperclassess.userdatas;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by anand on 6/15/2018.
 */

public class orderactivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> names = new ArrayList<>();
    userdatas userdatas = new userdatas();
    DatabaseReference rootref, orders;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemsmanagement);
        rootref = userdatas.rootref();
        mAdapter = new orderpageadapter(names);
        orders = rootref.child("server").child("users").child(userdatas.getuid()).child("orders");
        orders.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                listmanage(dataSnapshot);
            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                listmanage(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

           /*  orders.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterator i =dataSnapshot.getChildren().iterator();
                    Set<String> se = new HashSet<String>();
                    while(i.hasNext()){
                        se.add((((DataSnapshot)i.next()).getKey()));
                        names.clear();
                        names.addAll(se);
                }
            }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });*/
        recyclerView = (RecyclerView) findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }

    public void listmanage(DataSnapshot dataSnapshot) {
        Iterator i = dataSnapshot.getChildren().iterator();
        Set<String> se = new HashSet<String>();
        while (i.hasNext()) {
            //se.add((((DataSnapshot) i.next()).getKey()));
            //names.addAll(se);
            names.add((((DataSnapshot) i.next()).getKey()));

        }
        mAdapter.notifyDataSetChanged();
    }
}