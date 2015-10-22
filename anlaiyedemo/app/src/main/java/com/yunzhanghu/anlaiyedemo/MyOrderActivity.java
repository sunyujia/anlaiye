package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.yunzhanghu.anlaiyedemo.R.id.iv_content_money;
import static com.yunzhanghu.anlaiyedemo.R.id.iv_content_order;
import static com.yunzhanghu.anlaiyedemo.R.id.iv_content_service;

public class MyOrderActivity extends FragmentActivity implements View.OnClickListener {

    private ImageView mIvContent;

    private int mFromTag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_order);
        mFromTag = getIntent().getIntExtra("from", 0);
        ImageView ivBack = (ImageView) findViewById(R.id.iv_return);
        mIvContent = (ImageView) findViewById(iv_content_order);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        ivBack.setOnClickListener(this);
        mIvContent.setOnClickListener(this);
        if (mFromTag == 0) {
            mIvContent.setImageResource(R.drawable.my_mission_img);
        } else {
            //设置代付款图片
            mIvContent.setImageResource(0);
        }
        tvTitle.setText("俺消费的订单");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_return) {
            finish();
        } else {
            if (mFromTag == 0) {
                startActivityForResult(new Intent(this, FreeServiceActivity.class), 1001);
            } else {
                startActivityForResult(new Intent(this, FreeServiceActivity.class), 1001);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            //替换图片
            if (mFromTag == 0) {
                mIvContent.setImageResource(R.drawable.my_mission_complete_img);
            } else {
                mIvContent.setImageResource(0);
            }
        }
    }
}
