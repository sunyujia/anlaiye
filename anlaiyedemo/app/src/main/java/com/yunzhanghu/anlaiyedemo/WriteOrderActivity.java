package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class WriteOrderActivity extends Activity implements View.OnClickListener {


    ImageView mImageView;

    View mView;

    boolean canClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        findViewById(R.id.iv_return).setOnClickListener(this);
        findViewById(R.id.btn_oepn).setOnClickListener(this);
        findViewById(R.id.bottom).setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.bg);
        TextView tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("填写订单");
    }


    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "进入云账户", Toast.LENGTH_LONG).show();
        switch (v.getId()) {
            case R.id.btn_oepn:
                Intent intent = new Intent(this, ProfitActivity.class);
                startActivityForResult(intent, 1000);
                break;
            case R.id.iv_return:
                onBackPressed();
                break;
            case R.id.bottom:
//                if (canClick) {
                Intent intent2 = new Intent(this, OrderDetailActivity.class);
                startActivity(intent2);
//                }
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            canClick = true;
            mImageView.setImageResource(R.drawable.bg_write_order);
        }
    }
}
