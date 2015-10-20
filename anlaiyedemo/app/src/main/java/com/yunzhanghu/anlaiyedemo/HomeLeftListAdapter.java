package com.yunzhanghu.anlaiyedemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class HomeLeftListAdapter extends BaseAdapter {

    private Context context;

    private String[] titles;

    public HomeLeftListAdapter(Context context) {
        this.context = context;
        titles = context.getResources().getStringArray(R.array.home_left_titles);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.home_left_listview_item, parent, false);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.tv_category_tag);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.tv_goods_type_name);

        txtTitle.setText(titles[position]);
        if (position == 0) {
            txtTitle.setTextColor(convertView.getResources().getColor(R.color.red));
        }
//        if (position == 1) {
//            imgIcon.setImageResource(R.drawable.arrow_down);
//        }
//        if (position == 11) {
//            imgIcon.setImageResource(R.drawable.arrow_down);
//        }
        // displaying count
        // check whether it set visible or not
        return convertView;
    }

}
