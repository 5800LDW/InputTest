package com.nuaa.inputtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private Button mainBtn1;
    private Button mainBtn2;
    private Button mainBtn2_more_input;
    private Button mainBtn3;
    private Button mainBtn3_more_input;
    private Button mainBtn4;
    private Button mainBtn4_more_input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mainBtn1 = (Button) findViewById(R.id.main_btn_1);
        mainBtn2 = (Button) findViewById(R.id.main_btn_2);
        mainBtn2_more_input = (Button) findViewById(R.id.main_btn_2_more_input);
        mainBtn3 = (Button) findViewById(R.id.main_btn_3);
        mainBtn3_more_input = (Button) findViewById(R.id.main_btn_3_more_input);
        mainBtn4 = (Button) findViewById(R.id.main_btn_4);
        mainBtn4_more_input = (Button) findViewById(R.id.main_btn_4_more_input);
        mainBtn1.setOnClickListener(this);
        mainBtn2.setOnClickListener(this);
        mainBtn2_more_input.setOnClickListener(this);
        mainBtn3.setOnClickListener(this);
        mainBtn3_more_input.setOnClickListener(this);
        mainBtn4.setOnClickListener(this);
        mainBtn4_more_input.setOnClickListener(this);
        setStatusColor();
    }

    @Override
    public void onClick(View v) {
        int layoutId = 0;
        switch (v.getId()) {
            case R.id.main_btn_1:
                layoutId = R.layout.ways_one;
                break;
            case R.id.main_btn_2:
                layoutId = R.layout.ways_two;
                break;
            case R.id.main_btn_2_more_input:
                layoutId = R.layout.ways_two_more_input;
                break;
            case R.id.main_btn_3:
                layoutId = R.layout.ways_three;
                break;
            case R.id.main_btn_3_more_input:
                layoutId = R.layout.ways_three_more_input;
                break;
            case R.id.main_btn_4:
                layoutId = R.layout.ways_four;
                break;
            case R.id.main_btn_4_more_input:
                layoutId = R.layout.ways_four_more_input;
                break;
        }
        Intent intent = new Intent(this,ShowActivity.class);
        intent.putExtra("LayoutId",layoutId);
        startActivity(intent);
    }
}
