package com.example.lisiyan.bookmeal.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.ShopActivity;
import com.example.lisiyan.bookmeal.Utils.RandomUtils;

import java.util.List;

/**
 * Created by lisiyan on 2017/12/14.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{


    private List<String> shoplist;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClick( int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    public List<String> getShoplist() {
        return shoplist;
    }

    public void setShoplist(List<String> shoplist) {
        this.shoplist = shoplist;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mTextView.setText(shoplist.get(position));
        holder.mMoneyTextView.setText("¥"+ RandomUtils.randomNumber(20,50)+"起送|配送费¥"+RandomUtils.randomNumber(3,10));
        int distance = RandomUtils.randomNumber(1,10);
        int time = distance * 15;
        holder.mDatTextView.setText(distance+"km|"+time+"分钟");
        holder.mRatingBar.setRating(RandomUtils.randomNumber(3,5));
        if (mOnItemClickListener != null){
            holder.foodlist_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return shoplist== null?0:shoplist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;
        public TextView mMoneyTextView;
        public TextView mDatTextView;
        public RatingBar mRatingBar;
        private LinearLayout foodlist_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.shopname);
            mMoneyTextView = itemView.findViewById(R.id.money);
            mDatTextView = itemView.findViewById(R.id.distanceAndTime);
            mRatingBar = itemView.findViewById(R.id.foodStar);
            foodlist_layout = itemView.findViewById(R.id.foodlist_layout);

        }
    }

}
