package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

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
        mIvContent = (ImageView) findViewById(R.id.iv_content_order);
        findViewById(R.id.go_free_service).setOnClickListener(this);
        findViewById(R.id.go_order_detail).setOnClickListener(this);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        ivBack.setOnClickListener(this);
//        mIvContent.setOnClickListener(this);
//        if (mFromTag == 0) {
//            mIvContent.setImageResource(R.drawable.xxxxxxxx);
//        } else {
//            //设置代付款图片
//            mIvContent.setImageResource(R.drawable.my_mission_img);
//        }
        tvTitle.setText("俺消费的订单");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_return) {
            finish();
        } else {
//            if (mFromTag == 0) {
//                startActivityForResult(new Intent(this, OrderDetailActivity.class), 1001);
//            } else {
//                startActivityForResult(new Intent(this, FreeServiceActivity.class), 1001);
//            }
            if (v.getId() == R.id.go_free_service) {
                startActivityForResult(new Intent(this, FreeServiceActivity.class), 1001);

            } else {
                startActivityForResult(new Intent(this, OrderDetailActivity.class), 1001);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            //替换图片
            if (mFromTag != 0) {
                mIvContent.setImageResource(R.drawable.my_mission_complete_img);
            }
        }
    }
}
