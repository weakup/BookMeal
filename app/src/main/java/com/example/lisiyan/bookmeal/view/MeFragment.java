package com.example.lisiyan.bookmeal.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lisiyan.bookmeal.R;
import com.example.lisiyan.bookmeal.model.DataBaseImpl;

/**
 * Created by lisiyan on 2017/12/17.
 */

public class MeFragment extends Fragment {

    private TextView register;
    private LinearLayout loginLayout;
    private RelativeLayout registerLayout;
    private LinearLayout userpage;
    private Button registerbtn;
    private EditText reg_edtId;
    private EditText reg_edtPwd;
    private EditText login_edtId;
    private EditText login_edtPwd;
    private Button login_btnLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initData();
//        initView(view);
    }

    private void initView(View v){

        register = v.findViewById(R.id.register);
        loginLayout = v.findViewById(R.id.login_layout);
        registerLayout = v.findViewById(R.id.register_layout);
        userpage = v.findViewById(R.id.userpage);
        registerbtn = v.findViewById(R.id.register_btn);
        reg_edtId = v.findViewById(R.id.reg_edtId);
        reg_edtPwd = v.findViewById(R.id.reg_edtPwd);
        login_btnLogin =v.findViewById(R.id.login_btnLogin);
        login_edtId = v.findViewById(R.id.login_edtId);
        login_edtPwd = v.findViewById(R.id.login_edtPwd);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginLayout.setVisibility(View.GONE);
                userpage.setVisibility(View.GONE);
                registerLayout.setVisibility(View.VISIBLE);
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = DataBaseImpl.newInstance(getActivity()).insert(reg_edtId.getText().toString(),reg_edtPwd.getText().toString());

                if (result >0){

                    loginLayout.setVisibility(View.VISIBLE);
                    registerLayout.setVisibility(View.GONE);
                    userpage.setVisibility(View.GONE);
                }
            }
        });

        login_btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            boolean result =  DataBaseImpl.newInstance(getActivity()).query(login_edtId.getText().toString(),login_edtPwd.getText().toString());

                Log.d("result", String.valueOf(result));

                if (result){

                    loginLayout.setVisibility(View.GONE);
                    userpage.setVisibility(View.VISIBLE);
                    registerLayout.setVisibility(View.GONE);
                }
            }
        });


    }

    private void initData(){

        DataBaseImpl.newInstance(getActivity());
    }
}
