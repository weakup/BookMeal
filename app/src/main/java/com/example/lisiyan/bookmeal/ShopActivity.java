package com.example.lisiyan.bookmeal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lisiyan.bookmeal.view.ShopAdapter;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class ShopActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ShopAdapter mShopAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.shoplist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mShopAdapter = new ShopAdapter();
        mRecyclerView.setAdapter(mShopAdapter);
    }
}
