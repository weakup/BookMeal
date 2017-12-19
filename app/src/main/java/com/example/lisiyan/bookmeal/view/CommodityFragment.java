package com.example.lisiyan.bookmeal.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.ShopActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class CommodityFragment extends Fragment {

    RecyclerView mRecycleView;
    FoodListAdapter foodListAdapter;

    String food ="肯德基、全聚德";

    private List<String> foodlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.commodity_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
    }
    private void initView(View v){

        mRecycleView = v.findViewById(R.id.foodlist);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycleView.setHasFixedSize(true);
        foodListAdapter = new FoodListAdapter();
        foodListAdapter.setShoplist(foodlist);
        foodListAdapter.notifyDataSetChanged();
        mRecycleView.setAdapter(foodListAdapter);

        foodListAdapter.setOnItemClickListener(new FoodListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent =new Intent(getActivity(), ShopActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    private void initData(){

        foodlist = new ArrayList();

        String []foods = food.split("、");

        for (int i=0;i<foods.length;i++){

            foodlist.add(foods[i]);
        }
    }

}
