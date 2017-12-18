package com.example.lisiyan.bookmeal.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.ShopActivity;

/**
 * Created by lisiyan on 2017/12/16.
 */

public class HomeFragment extends Fragment {

    private ImageView meishi;
    private ImageView wancan;
    private ImageView bianli;
    private ImageView zacuan;
    private ImageView guoshu;
    private ImageView xindian;
    private ImageView dazhe;
    private ImageView tianpin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView(view);
        initLinstener();
    }

    private void bindView(View view){

        meishi = view.findViewById(R.id.meishi);

    }

    private void initLinstener(){

        meishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(), ShopActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
}
