package com.yunzhanghu.anlaiyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by yyyy on 15/10/20.
 */
public class ShoppingCartFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        view.findViewById(R.id.btn_oepn).setOnClickListener(this);
        TextView tv = (TextView) view.findViewById(R.id.tv_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.home_title_personinfo);
        imageView.setImageResource(R.drawable.shopcar_delete_icon);
        view.findViewById(R.id.home_title_right).setVisibility(View.VISIBLE);
        tv.setText("购物车");
        return view;
    }

    @Override
    public void onClick(View v) {
        if (getActivity() != null) {
            getActivity().startActivity(new Intent(getActivity(), FruitActivity.class));
        }
    }
}
