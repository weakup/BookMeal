package com.example.lisiyan.bookmeal.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.model.FoodModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lisiyan on 2017/12/18.
 */

public class BuyCarFragmnt extends Fragment {

    private List<FoodModel> mFoodModels = new ArrayList<>();
    private BuyCarListAdapter mBuyCarListAdapter;
    private RecyclerView mRecyclerView;
    private Button jiezhang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buycar_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View v){

        mRecyclerView = v.findViewById(R.id.buycarlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mBuyCarListAdapter = new BuyCarListAdapter();
        mBuyCarListAdapter.setBuycarList(mFoodModels);
        mRecyclerView.setAdapter(mBuyCarListAdapter);
        jiezhang = v.findViewById(R.id.jiesuan);
        jiezhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"付款成功，骑手正在送货",Toast.LENGTH_LONG).show();
                mFoodModels.clear();
                mBuyCarListAdapter.notifyDataSetChanged();
                jiezhang.setVisibility(View.GONE);
            }
        });
    }

    public void updataData(List<FoodModel> foodModels){
        mFoodModels.clear();
        mFoodModels.addAll(foodModels);
        mBuyCarListAdapter.notifyDataSetChanged();
        if (foodModels.isEmpty()){

            jiezhang.setVisibility(View.GONE);
        }else {

            jiezhang.setVisibility(View.VISIBLE);
        }
    }

}
