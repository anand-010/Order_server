package com.android.order_ser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


/**
 * Created by anand on 6/12/2018.
 */

public class orderpageadapter extends RecyclerView.Adapter<orderpageadapter.ViewHolder> {
    List<String> namelist;//,phoneno,placelist,items,quantity,prize;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View layout;
        TextView name;/*,phonenumber,place,item1,
                item2,item3,item4,item5,item6
                ,quantity1,quantity2,quantity3,
                quantity4,quantity5,quantity6,
                prize1,prize2,prize3,prize4,prize5,prize6;
        Button accept,reject,reliability */
        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            name = (TextView)itemView.findViewById(R.id.textView13);

            /*phonenumber = (TextView)itemView.findViewById(R.id.textView14);
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
            reliability = (Button) itemView.findViewById(R.id.reliability);
*/

        }
    }
    public orderpageadapter(List<String> namelist){

        this.namelist = namelist;

    }

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
        final String names = namelist.get(position);
        /*final String phone = phoneno.get(position);
        final String placelists = placelist.get(position);
        final String itemss = items.get(position);
        final String quantitys  = quantity.get(position);
        final String prizes  = prize.get(position);

        holder.name.setText(names);
        holder.phonenumber.setText(phone);
        holder.place.setText(placelists);
        holder.item1.setText(itemss);
        holder.quantity1.setText(quantitys);
        holder.prize1.setText(prizes);
        */
        holder.name.setText(names);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return namelist.size();
    }
}

