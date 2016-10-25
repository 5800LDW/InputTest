package com.nuaa.inputtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by time++ on 2016/10/23 20:38.
 * Email:873438791@qq.com
 */
public class ShowActivity extends BaseActivity implements ViewTreeObserver.OnGlobalLayoutListener {
    private TextView registerLogo;
    private Button registerBtnRegister;
    private View rootView;
    private boolean keyboardFlag = false;
    private final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private boolean flag = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId  = getIntent().getIntExtra("LayoutId",0);
        if(layoutId == R.layout.ways_one)
            flag = true;
        setContentView(layoutId);
        initView();
    }

    private void initView() {
        registerLogo = (TextView) findViewById(R.id.register_logo);
        registerBtnRegister = (Button) findViewById(R.id.register_btn_register);

        setStatusColor();

        if(flag)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this);


    }
    @Override
    public void onGlobalLayout() {
        final int headerHeight = CommonUtil.getStatusHeight(this);
        final int margin = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        int heightDiff = rootView.getRootView().getHeight() - rootView.getHeight();
        if (heightDiff > headerHeight) {
            if (!keyboardFlag) {
                registerLogo.setVisibility(View.GONE);
                if(flag) {
                    layoutParams.setMargins(margin, 0, margin, CommonUtil.dip2px(this, 10));
                    registerBtnRegister.setLayoutParams(layoutParams);
                }
                keyboardFlag = true;
                Log.e("keyboard", "keyboard is show");
            }
        }
        if (heightDiff <= headerHeight) {
            if (keyboardFlag) {
                registerLogo.setVisibility(View.VISIBLE);
                if(flag) {
                    layoutParams.setMargins(margin, 0, margin, getResources().getDimensionPixelSize(R.dimen.register_bottom_margin));
                    registerBtnRegister.setLayoutParams(layoutParams);
                }
                keyboardFlag = false;
                Log.e("keyboard", "keyboard is hidden");
            }
        }

    }
}
