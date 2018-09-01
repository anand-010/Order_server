package com.android.order_ser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by anand on 6/12/2018.
 */

public class orderpageadapter extends RecyclerView.Adapter<orderpageadapter.ViewHolder> {
    int k=0,d=0,c=0;
    List<String> namelist,phonenolist,placelist,items,quantity,prize,tempitem;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View layout;
        TextView name,phonenumber,place,item1,
                item2,item3,item4,item5,item6
                ,quantity1,quantity2,quantity3,
                quantity4,quantity5,quantity6,
                prize1,prize2,prize3,prize4,prize5,prize6;
        Button accept,reject,reliability;
        public ViewHolder(View itemView) {

            super(itemView);
            layout = itemView;
            name = (TextView)itemView.findViewById(R.id.textView13);
            tempitem = new ArrayList<>();
            phonenumber = (TextView)itemView.findViewById(R.id.textView14);
            item1 = (TextView)itemView.findViewById(R.id.item1);
            item2 = (TextView)itemView.findViewById(R.id.item2);
            item3 = (TextView)itemView.findViewById(R.id.item3);
            item4 = (TextView)itemView.findViewById(R.id.item4);
            item5 = (TextView)itemView.findViewById(R.id.item5);
            item6 = (TextView)itemView.findViewById(R.id.item6);
            quantity1 = (TextView)itemView.findViewById(R.id.quantity1);
            quantity2 = (TextView)itemView.findViewById(R.id.quantity2);
            quantity3 = (TextView)itemView.findViewById(R.id.quantity3);
            quantity4 = (TextView)itemView.findViewById(R.id.quantity4);
            quantity5 = (TextView)itemView.findViewById(R.id.quantity5);
            quantity6 = (TextView)itemView.findViewById(R.id.quantity6);
            prize1 = (TextView)itemView.findViewById(R.id.calprize1);
            prize2 = (TextView)itemView.findViewById(R.id.calprize2);
            prize3 = (TextView)itemView.findViewById(R.id.calprize3);
            prize4 = (TextView)itemView.findViewById(R.id.calprize4);
            prize5 = (TextView)itemView.findViewById(R.id.calprize5);
            prize6 = (TextView)itemView.findViewById(R.id.calprize6);
            accept = (Button) itemView.findViewById(R.id.accept);
            reject = (Button) itemView.findViewById(R.id.reject);
            place = (TextView)itemView.findViewById(R.id.place);
            reliability = (Button) itemView.findViewById(R.id.reliability);

        }
    }
    public orderpageadapter(List<String> namelist,List<String> phonenolist,
                            List<String> placelist,List<String> items,
                            List<String> quantity,List<String> prize){

        this.namelist = namelist;
        this.phonenolist     = phonenolist    ;
        this.placelist   = placelist  ;
        this.items      = items;
        this.quantity    = quantity   ;
        this.prize       = prize      ;

    }
    public void anand(){notify();}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.orderoriginal, parent, false);
        // set the view's size, margins, paddings and layout parameters
        orderpageadapter.ViewHolder vh = new orderpageadapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            for (d=0;d<6;d++){
                switch (d){
                    case 0: holder.item1.setText(items.get(d+position*6)); break;
                    case 1: holder.item2.setText(items.get(d+position*6)); break;
                    case 2: holder.item3.setText(items.get(d+position*6)); break;
                    case 3: holder.item4.setText(items.get(d+position*6)); break;
                    case 4: holder.item5.setText(items.get(d+position*6)); break;
                    case 5: holder.item6.setText(items.get(d+position*6)); break;
                }
        }

        if (namelist.size()>position) {
            String names = namelist.get(position);
            holder.name.setText(names);
        }
        if (phonenolist.size()>position) {
            String phone = phonenolist.get(position);
            holder.phonenumber.setText(phone);
        }
        if (phonenolist.size()>position)
        {
            String placelists = placelist.get(position);
            holder.place.setText(placelists);
        }
        if (items.size()>position){
            String itr = items.get(position);
            holder.item1.setText(itr);
        }
        if (quantity.size()>position){
            String quantitys = quantity.get(position);
            holder.quantity1.setText(quantitys);
        }
        if (prize.size()>position){
            String prizes = prize.get(position);
            holder.prize1.setText(prizes);
        }








        //new

    }

    @Override
    public int getItemCount() {
        return namelist.size();
    }

    public void add(int position, String item) {
        namelist.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        namelist.remove(position);
        notifyItemRemoved(position);
    }
}

