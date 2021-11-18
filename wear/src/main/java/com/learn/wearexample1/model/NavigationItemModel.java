package com.learn.wearexample1.model;

import androidx.annotation.DrawableRes;

public class NavigationItemModel {
    private String title;
    private String text;
    private @DrawableRes int icon;

    public NavigationItemModel(String title, String text, @DrawableRes int icon) {
        this.title = title;
        this.text = text;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }
}
