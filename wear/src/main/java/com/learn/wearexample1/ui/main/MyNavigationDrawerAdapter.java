package com.learn.wearexample1.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import com.learn.wearexample1.model.NavigationItemModel;

import java.util.ArrayList;

public class MyNavigationDrawerAdapter extends WearableNavigationDrawerView.WearableNavigationDrawerAdapter {
    private final ArrayList<NavigationItemModel> items;
    private final Context context;

    public MyNavigationDrawerAdapter(Context context, ArrayList<NavigationItemModel> items) {
        this.context = context;
        this.items = items;
    }

    public NavigationItemModel getItem(int pos) {
        return items.get(pos);
    }

    @Override
    public CharSequence getItemText(int pos) {
        NavigationItemModel item = items.get(pos);
        if (item != null) {
            return item.getTitle();
        }
        return "";
    }

    @Override
    public Drawable getItemDrawable(int pos) {
        NavigationItemModel item = items.get(pos);
        if (item != null) {
            return context.getDrawable(item.getIcon());
        }
        return null;
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
