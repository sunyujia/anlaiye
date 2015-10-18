package com.jiandanlicai.anlaiyedemo;

public class NavDrawerItem {

    private String title;
    private int icon;
    // boolean to set visiblity of the counter
    private boolean isArrowVisible = false;

    public NavDrawerItem() {
    }

    public NavDrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public NavDrawerItem(String title, int icon, boolean isArrowVisible) {
        this.title = title;
        this.icon = icon;
        this.isArrowVisible = isArrowVisible;
    }

    public String getTitle() {
        return this.title;
    }

    public int getIcon() {
        return this.icon;
    }

    public boolean getCounterVisibility() {
        return this.isArrowVisible;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setCounterVisibility(boolean isArrowVisible) {
        this.isArrowVisible = isArrowVisible;
    }
}
