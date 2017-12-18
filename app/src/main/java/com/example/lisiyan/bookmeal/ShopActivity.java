package com.example.lisiyan.bookmeal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lisiyan.bookmeal.Utils.RandomUtils;
import com.example.lisiyan.bookmeal.model.FoodModel;
import com.example.lisiyan.bookmeal.view.ShopAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class ShopActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShopAdapter mShopAdapter;
    List<FoodModel> foodModels = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initModel();
        initView();
    }

    private void initModel(){


        int count = RandomUtils.randomNumber(0,RandomUtils.foods.length-1);

        for (int i=0 ; i< count ;i++){

            FoodModel foodModel = new FoodModel();
            foodModel.setName(RandomUtils.foods[i]);
            foodModel.setMoney(RandomUtils.randomNumber(10,30));
            foodModel.setCount(1);
            foodModels.add(foodModel);

        }


    }

    private void initView(){
        mRecyclerView = findViewById(R.id.shoplist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mShopAdapter = new ShopAdapter();
        mShopAdapter.setCountlist(foodModels);
        mShopAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mShopAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent();
        intent.putExtra("foolModels", (Serializable) foodModels);
        this.setResult(RESULT_OK,intent);
        super.onBackPressed();
    }
}
