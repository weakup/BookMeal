package com.example.lisiyan.bookmeal.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.R;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView foodName;
        TextView sell;
        TextView money;
        public ViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodname);
            sell = itemView.findViewById(R.id.sell);
            money = itemView.findViewById(R.id.money);
        }
    }
}
