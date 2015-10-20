package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class FruitActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        findViewById(R.id.btn_oepn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        Toast.makeText(this, "进入云账户", Toast.LENGTH_LONG).show();
//        todo 进入实名认证过程
        
    }
}
