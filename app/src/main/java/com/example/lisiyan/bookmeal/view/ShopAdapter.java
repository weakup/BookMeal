package com.example.lisiyan.bookmeal.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.model.FoodModel;

import java.util.List;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder>{

    private List<FoodModel> countlist;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buy_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.foodName.setText(countlist.get(position).getName());
        holder.money.setText("¥ "+countlist.get(position).getMoney());
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = countlist.get(position).getCount()+1;
                countlist.get(position).setCount(count);
                holder.count.setText(String.valueOf(count));
                Log.d("shop", String.valueOf(holder.getLayoutPosition()));
            }
        });

        holder.subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = countlist.get(position).getCount()-1;
                if (count >= 0) {
                    countlist.get(position).setCount(count);
                    holder.count.setText(String.valueOf(count));
                    Log.d("shop", String.valueOf(holder.getLayoutPosition()));
                }
            }
        });
    }

    public List<FoodModel> getCountlist() {
        return countlist;
    }

    public void setCountlist(List<FoodModel> countlist) {
        this.countlist = countlist;
    }

    @Override
    public int getItemCount() {
        return countlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView foodName;
        TextView sell;
        TextView money;
        ImageButton add;
        ImageButton subtraction;
        TextView count;
        public ViewHolder(View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodname);
            sell = itemView.findViewById(R.id.sell);
            money = itemView.findViewById(R.id.buymomey);
            add = itemView.findViewById(R.id.add);
            subtraction = itemView.findViewById(R.id.subtraction);
            count = itemView.findViewById(R.id.count);
        }

    }
}
