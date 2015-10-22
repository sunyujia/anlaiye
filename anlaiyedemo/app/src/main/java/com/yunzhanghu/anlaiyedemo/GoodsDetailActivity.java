package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GoodsDetailActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        TextView tv = (TextView) findViewById(R.id.tv_title);
        findViewById(R.id.iv_return).setOnClickListener(this);
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.home_title_personinfo);
        imageView.setImageResource(R.drawable.my_cart);
        tv.setText("商品详情");
        findViewById(R.id.iv_goods_detail).setOnClickListener(this);
        findViewById(R.id.home_title_right).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return:
                onBackPressed();
                break;
            case R.id.iv_goods_detail:
                startActivityForResult(new Intent(this, RuleActivity.class), 100001);
                break;
            case R.id.btn_left:
                break;
            case R.id.btn_right:
//                todo  进入购物车
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100001) {
            Toast.makeText(this, "立减6元置灰", Toast.LENGTH_SHORT).show();
        }
    }
}
