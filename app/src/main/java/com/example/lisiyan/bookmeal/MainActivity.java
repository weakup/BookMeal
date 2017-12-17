
package com.example.lisiyan.bookmeal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lisiyan.bookmeal.view.FoodListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycleView;
    FoodListAdapter foodListAdapter;

    String food = "蒸羊羔、蒸熊掌、蒸鹿尾儿、烧花鸭、烧雏鸡、烧子鹅、卤猪、卤鸭、酱鸡、腊肉、松花小肚儿、晾肉、香肠儿、什锦苏盘、熏鸡白肚儿、清蒸八宝猪";

    private List<String> foodlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commodity_fragment);

        initData();
        initView();
    }

    private void initView() {

        mRecycleView = findViewById(R.id.foodlist);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setHasFixedSize(true);
        foodListAdapter = new FoodListAdapter();
        foodListAdapter.setShoplist(foodlist);
        mRecycleView.setAdapter(foodListAdapter);

    }

    private void initData() {

        foodlist = new ArrayList();

        String[] foods = food.split("、");

        for (int i = 0; i < foods.length; i++) {

            foodlist.add(foods[i]);
        }
    }
}
