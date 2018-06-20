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

    public class viewholder extends RecyclerView.ViewHolder{
        TextView textView;
        public viewholder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView20);
        }
    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.itemmanagementmodel, parent, false);
        // set the view's size, margins, paddings and layout parameters
        itemmanagementadapter.viewholder vh = new itemmanagementadapter.viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
