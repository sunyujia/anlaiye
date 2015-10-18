package com.jiandanlicai.anlaiyedemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;

    private List<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, List<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
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
            convertView = mInflater.inflate(R.layout.drawer_list_item, parent, false);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        ImageView imgArrow = (ImageView) convertView.findViewById(R.id.iv_arrow);

        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        if (position == 0) {
            txtTitle.setTextColor(context.getResources().getColor(R.color.order_yellow));
        }
        // displaying count
        // check whether it set visible or not
        if (navDrawerItems.get(position).getCounterVisibility()) {
            imgArrow.setVisibility(View.VISIBLE);
        } else {
            // hide the counter view
            imgArrow.setVisibility(View.GONE);
        }

        return convertView;
    }

}
