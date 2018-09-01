package com.android.order_ser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anand on 6/18/2018.
 */

public class itemmanagementadapter extends RecyclerView.Adapter<itemmanagementadapter.viewholder> {
    List<String> items;
    List<String> dates;
    List<String> prizes;
    List<String> statuses;
    public itemmanagementadapter(List<String> items,List<String> date,List<String> prize,List<String> status) {
        this.items = items;
        this.dates = date;
        this.prizes = prize;
        this.statuses = status;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView textView,nam,dat,priz,status;
        public viewholder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView20);
            nam = (TextView)itemView.findViewById(R.id.textView20);
            dat = (TextView)itemView.findViewById(R.id.textView20);
            priz = (TextView)itemView.findViewById(R.id.textView20);
            status = (TextView)itemView.findViewById(R.id.textView20);
//             = (TextView)itemView.findViewById(R.id.textView20);
        }
    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.itemnewmodel, parent, false);
        // set the view's size, margins, paddings and layout parameters
        itemmanagementadapter.viewholder vh = new itemmanagementadapter.viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {
            holder.textView.setText(items.get(position));
//        holder.nam.setText(items.get(position));
//        holder.dat.setText(dates.get(position));
//        holder.priz.setText(prizes.get(position));
//        holder.status.setText(statuses.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
