package com.example.lisiyan.bookmeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.model.FoodModel;
import com.example.lisiyan.bookmeal.view.BuyCarFragmnt;
import com.example.lisiyan.bookmeal.view.CommodityFragment;
import com.example.lisiyan.bookmeal.view.HomeFragment;
import com.example.lisiyan.bookmeal.view.MeFragment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class ViewPageActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyFragmentPagerAdapter mPagerAdapter;
    BuyCarFragmnt mBuyCarFragmnt = new BuyCarFragmnt();
    //Tab 文字
    private final int[] TAB_TITLES = new int[]{R.string.home,R.string.commodity,R.string.shopping,R.string.my};
    //Tab 图片
    private final int[] TAB_IMGS = new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
    //Fragment 数组
    private final Fragment[] TAB_FRAGMENTS = new Fragment[] {new HomeFragment(),new CommodityFragment(),mBuyCarFragmnt,new MeFragment()};
    //Tab 数目
    private final int COUNT = TAB_TITLES.length;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){

        mTabLayout = findViewById(R.id.tablayout);
        setTabs(mTabLayout,this.getLayoutInflater(),TAB_TITLES,TAB_IMGS);

        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    /**
     * @description: 设置添加Tab
     */
    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitlees, int[] tabImgs){
        for (int i = 0; i < tabImgs.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.tab_custom,null);
            tab.setCustomView(view);
            TextView tvTitle = view.findViewById(R.id.tv_tab);
            tvTitle.setText(tabTitlees[i]);
            tabLayout.addTab(tab);

        }
    }


    private class MyFragmentPagerAdapter extends FragmentPagerAdapter{


         MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

             return TAB_FRAGMENTS[position];
        }

        @Override
        public int getCount() {
            return COUNT;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<FoodModel> foodModels = (List<FoodModel>) data.getExtras().getSerializable("foolModels");//得到新Activity 关闭后返回的数据
        Bundle  bundle = new Bundle();
        bundle.putSerializable("foodlist", (Serializable) foodModels);
        mBuyCarFragmnt.setArguments(bundle);

    }
}
