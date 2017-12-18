package com.example.lisiyan.bookmeal.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.model.FoodModel;

import java.util.List;

/**
 * Created by lisiyan on 2017/12/18.
 */

public class BuyCarListAdapter extends RecyclerView.Adapter<BuyCarListAdapter.ViewHolder>{

    private List<FoodModel> buycarList;


    public List<FoodModel> getBuycarList() {
        return buycarList;
    }

    public void setBuycarList(List<FoodModel> buycarList) {
        this.buycarList = buycarList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buycar_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.foodname.setText(buycarList.get(position).getName());
        int count = buycarList.get(position).getCount();
        int money = buycarList.get(position).getMoney() * count;
        holder.foodMony.setText("价格: ¥"+String.valueOf(money));
        holder.foodcount.setText("数量:"+String.valueOf(count));
    }

    @Override
    public int getItemCount() {
        return buycarList== null?0:buycarList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView foodname;
        private TextView foodcount;
        private TextView foodMony;

        public ViewHolder(View itemView) {
            super(itemView);


            foodMony = itemView.findViewById(R.id.foodMony);
            foodcount = itemView.findViewById(R.id.foodcount);
            foodname = itemView.findViewById(R.id.foodname);

        }
    }

}
