package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements MenuFragment.SLMenuListOnItemClickListener, HomeFragment.ChangeContentListener, ShoppingCartFragment.OnViewClickListener {

    private SlidingMenu mSlidingMenu;

    private RadioGroup radioGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_content);
        radioGroup = (RadioGroup) findViewById(R.id.tab_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeContent(group, checkedId);
            }
        });
        setBehindContentView(R.layout.frame_left_menu);
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT);
        mSlidingMenu.setSecondaryMenu(R.layout.frame_right_menu);
//        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset165);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.left_menu, new MenuFragment());
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();
    }

    @Override
    public void selectItem(int position, String title) {
        if (position == 4) {
            startActivity(new Intent(this, ZeroPayActivity.class));
        }
        Toast.makeText(this, "position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeContent(RadioGroup group, int checkedId) {
        Fragment fragment = null;
        switch (checkedId) {
            case R.id.rb_first:
                fragment = new HomeFragment();
                break;
            case R.id.rb_second:
                fragment = new ShoppingCartFragment();
                break;
            case R.id.rb_forth:
                fragment = new UserInfoFragment();
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
        }
    }

    @Override
    public void onContentClickListener(View v) {
        switch (v.getId()) {
            case R.id.iv_goods:
                startActivity(new Intent(this, GoodsDetailActivity.class));
                break;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        radioGroup.check(R.id.rb_second);
    }

    @Override
    public void onViewClick(View view) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content);
        if (fragment instanceof ShoppingCartFragment) {
            ShoppingCartFragment scf = (ShoppingCartFragment) fragment;
            if (scf.canClick) {
                startActivityForResult(new Intent(this, FruitActivity.class), 888);
            } else {
                ImageView imageView = (ImageView) findViewById(R.id.iv_shopping_cart);
                imageView.setImageResource(R.drawable.bg_shopping_cart_pre);
                scf.canClick = true;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("xxx", "resultCode: " + resultCode);
        if (requestCode == 888 && resultCode == RESULT_OK) {
//            Toast.makeText(this, "换图", Toast.LENGTH_LONG).show();
            ImageView imageView = (ImageView) findViewById(R.id.iv_shopping_cart);
            imageView.setImageResource(R.drawable.bg_shopping_cart);
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content);
            if (fragment instanceof ShoppingCartFragment) {
                ((ShoppingCartFragment) fragment).canClick = false;
            }
        }
    }
}
