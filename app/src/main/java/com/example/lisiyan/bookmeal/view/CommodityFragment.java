package com.example.lisiyan.bookmeal.view;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class CommodityFragment extends Fragment {

    RecyclerView mRecycleView;
    FoodListAdapter foodListAdapter;

    String food ="蒸羊羔、蒸熊掌、蒸鹿尾儿、烧花鸭、烧雏鸡、烧子鹅、卤猪、卤鸭、酱鸡、腊肉、松花小肚儿、晾肉、香肠儿、什锦苏盘、熏鸡白肚儿、清蒸八宝猪";

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

    }

    private void initData(){

        foodlist = new ArrayList();

        String []foods = food.split("、");

        for (int i=0;i<foods.length;i++){

            foodlist.add(foods[i]);
        }
    }

}
