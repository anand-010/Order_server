package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.order_ser.helperclassess.userdatas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by anand on 6/19/2018.
 */

public class itemmanagementactivity extends AppCompatActivity {
    userdatas userdatas = new userdatas();
    List<String> names = new ArrayList();
    List<String> date = new ArrayList<>();
    List<String> prize = new ArrayList<>();
    List<String> item = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemsmanagement);
        DatabaseReference rootref = userdatas.rootref();
        String uid = userdatas.getuid();
        rootref.child("server").child(uid).child("items");
        rootref.addChildEventListener(new ChildEventListener() {
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


    }

    private void childfunc(DataSnapshot d) {
        Iterator i = d.getChildren().iterator();
        Set<String> se = new HashSet<String>();
        while (i.hasNext()) {
            String portion = "";
            portion = ((DataSnapshot) i.next()).getKey().toString();


            names.add(d.child("zxv").toString());

            prize.add(d.child("zxv").toString());

            prize.add(d.child("zxv").toString());


        }
    }
}
