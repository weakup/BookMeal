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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getArguments() !=null && getArguments().getSerializable("foodlist") != null){
            mFoodModels.clear();
            mFoodModels.addAll((Collection<? extends FoodModel>) getArguments().getSerializable("foodlist"));
            Log.d("buycar",mFoodModels.get(0).getName());
        }

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
        mBuyCarListAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mBuyCarListAdapter);
    }

}
