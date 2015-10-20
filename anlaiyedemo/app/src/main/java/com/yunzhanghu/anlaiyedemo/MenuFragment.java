package com.yunzhanghu.anlaiyedemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by max on 15/10/12.
 */
public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mMenuList;

    private String[] mMenuTitles;

    private TypedArray mMenuIconsTypeArray;

    private ArrayList<NavDrawerItem> mMenuItems;

    private NavDrawerListAdapter mAdapter;

    private SLMenuListOnItemClickListener mCallback;

    private int selected = -1;


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mCallback = (SLMenuListOnItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SLMenuListOnItemClickListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_left_list, null);
        initList(rootView);
        return rootView;
    }

    private void initList(View rootView) {
        mMenuList = (ListView) rootView.findViewById(R.id.menu_list);
        mMenuTitles = getResources().getStringArray(R.array.menu_titles);
        mMenuIconsTypeArray = getResources().obtainTypedArray(R.array.menulist_img);
        mMenuItems = new ArrayList<NavDrawerItem>();
        mMenuItems.add(new NavDrawerItem(mMenuTitles[0], mMenuIconsTypeArray.getResourceId(0, -1), true));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[1], mMenuIconsTypeArray.getResourceId(1, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[2], mMenuIconsTypeArray.getResourceId(2, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[3], mMenuIconsTypeArray.getResourceId(3, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[4], mMenuIconsTypeArray.getResourceId(4, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[5], mMenuIconsTypeArray.getResourceId(5, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[6], mMenuIconsTypeArray.getResourceId(6, -1)));
        mMenuItems.add(new NavDrawerItem(mMenuTitles[6], mMenuIconsTypeArray.getResourceId(7, -1)));

        mMenuIconsTypeArray.recycle();
        mAdapter = new NavDrawerListAdapter(getActivity(), mMenuItems);
        mMenuList.setAdapter(mAdapter);
        mMenuList.setOnItemClickListener(this);
        if (selected != -1) {
            mMenuList.setItemChecked(selected, true);
            mMenuList.setSelection(selected);
        } else {
            mMenuList.setItemChecked(0, true);
            mMenuList.setSelection(0);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mMenuList.setItemChecked(position, true);
        mMenuList.setSelection(position);
        if (mCallback != null) {
            mCallback.selectItem(position, mMenuTitles[position]);
        }
        selected = position;
    }

    public interface SLMenuListOnItemClickListener {
        void selectItem(int position, String title);
    }

}
