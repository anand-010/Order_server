package com.android.order_ser;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.android.order_ser.helperclassess.Order_projo;
import com.android.order_ser.helperclassess.userdatas;
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
 * Created by anand on 6/15/2018.
 */

public class orderactivity extends AppCompatActivity {
    int c=0;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> phoneno     = new ArrayList<>();
    private List<String> placelist   = new ArrayList<>();
    private List<String> items       = new ArrayList<>();
    private List<String> quantity    = new ArrayList<>();
    private List<String> prize       = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private List<String> itemlist = new ArrayList<>();
    userdatas userdatas = new userdatas();
    DatabaseReference rootref, orders;
//test
    private TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemsmanagement);
//        textView = (TextView)findViewById(R.id.testone);
        rootref = FirebaseDatabase.getInstance().getReference().getRoot();
        mAdapter = new orderpageadapter(names,phoneno,placelist,items,quantity,prize);
        orders = rootref.child("server").child("users").child(userdatas.getuid()).child("orders");
        orders.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                listmanage(dataSnapshot);
                mAdapter.notifyDataSetChanged();
            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                listmanage(dataSnapshot);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                listmanage(dataSnapshot);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                listmanage(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
//new
        recyclerView = (RecyclerView) findViewById(R.id.recv);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }
    //new
    DataSnapshot sth;
    String fg="d :";
    public void listmanage(DataSnapshot dataSnapshot) {
        Order_projo order_projo = dataSnapshot.getValue(Order_projo.class);
        names     .add(order_projo.getNames());
        phoneno   .add(order_projo.getPhoneno());
        placelist .add(order_projo.getPlacelist());
        //items     .add(order_projo.getItems());
        quantity  .add(order_projo.getQuantity());
        prize     .add(order_projo.getPrize());

        sth = dataSnapshot.child(String.valueOf("itemlist"));
        Iterator i = sth.getChildren().iterator();
        while (i.hasNext()) {
            items.add(((DataSnapshot) i.next()).getValue().toString());

        }Toast.makeText(this, items.toString(), Toast.LENGTH_SHORT).show();
//        items.add("ende");
//        for (int t=1 ;t<listOLists.size();t++){
//
//        for (int k =0; k<items.size();k++)
//        {
//            fg = fg +items.get(k);
//            textView.setText(fg);
//        }
//        }
          // textView.setText((CharSequence) items);
        /*Iterator i = dataSnapshot.getChildren().iterator();
        Set<String> se = new HashSet<String>();
        while (i.hasNext()) {
            //se.add((((DataSnapshot) i.next()).getKey()));
            //names.addAll(se);
            names     .add((((DataSnapshot) i.next()).getKey()));
            phoneno   .add((((DataSnapshot) i.next()).getKey()));
            placelist .add((((DataSnapshot) i.next()).getKey()));
            items     .add((((DataSnapshot) i.next()).getKey()));
            quantity  .add((((DataSnapshot) i.next()).getKey()));
            prize     .add((((DataSnapshot) i.next()).getKey()));
        }*/
    }
}