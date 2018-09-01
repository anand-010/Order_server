package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.order_ser.helperclassess.userdatas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by anand on 6/19/2018.
 */

public class itemmanagementactivity extends AppCompatActivity {
    String itemname;
    String priz;
    String lastupdatetime;
    String offer;
    String status;

    userdatas userdatas = new userdatas();
    List<String> names = new ArrayList();
    List<String> date = new ArrayList<>();
    List<String> prize = new ArrayList<>();
    List<String> item = new ArrayList<>();
    List<String> statu = new ArrayList<>();
    private RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;
    private DatabaseReference rootref;
    private String uid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemsmanagement);
        uid = userdatas.getuid();
        mAdapter = new itemmanagementadapter(names,date,prize,statu);
        rootref = userdatas.rootref();
        rootref.child("server").child("users").child(uid).child("items")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        childfunc(dataSnapshot);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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
        names.add("anand");
        recyclerView = (RecyclerView) findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void childfunc(DataSnapshot d) {
        Iterator i = d.getChildren().iterator();
        Set<String> se = new HashSet<String>();
        while (i.hasNext()) {


            itemname= ((DataSnapshot) i.next()).getValue().toString();
            priz=((DataSnapshot) i.next()).getKey().toString();
            lastupdatetime= ((DataSnapshot) i.next()).getKey().toString();
            status = ((DataSnapshot) i.next()).getKey().toString();
            names.add(itemname);
            date.add(lastupdatetime);
            prize.add(priz);
            statu.add(status);
            mAdapter.notifyDataSetChanged();
        }

    }
}
