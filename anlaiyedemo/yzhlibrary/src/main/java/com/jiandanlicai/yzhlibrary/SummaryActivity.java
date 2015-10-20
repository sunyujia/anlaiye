package com.jiandanlicai.yzhlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

public class SummaryActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        ImageView imageView = (ImageView) findViewById(R.id.iv_content_summary);
        imageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, YzhActivity.class));
    }

}
