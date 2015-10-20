package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.jiandanlicai.yzhlibrary.RealNameActivity;

public class FruitActivity extends Activity implements View.OnClickListener {

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        findViewById(R.id.btn_oepn).setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.bg);
    }


    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "进入云账户", Toast.LENGTH_LONG).show();
//        todo 进入实名认证过程
        startActivityForResult(new Intent(this, RealNameActivity.class), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Toast.makeText(this, "换图", Toast.LENGTH_LONG).show();
//            mImageView.setImageResource();
        }
    }
}
