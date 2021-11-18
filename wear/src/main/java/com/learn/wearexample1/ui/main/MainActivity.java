package com.learn.wearexample1.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.wear.widget.drawer.WearableDrawerLayout;
import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import com.learn.wearexample1.R;
import com.learn.wearexample1.databinding.ActivityMainBinding;
import com.learn.wearexample1.model.NavigationItemModel;
import com.learn.wearexample1.ui.details.DetailsActivity;
import com.learn.wearexample1.ui.list.ListActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private WearableNavigationDrawerView mNavigationDrawer;
    private ImageButton mBtnHome;
    private ImageButton mBtnList;
    private ImageButton mBtnInfo;
    private ImageButton mBtnExit;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mNavigationDrawer = binding.navigationDrawer;
        mBtnHome = binding.btnHome;
        mBtnList = binding.btnList;
        mBtnInfo = binding.btnInfo;
        mBtnExit = binding.btnExit;

        MyNavigationDrawerAdapter navigationAdapter = new MyNavigationDrawerAdapter(MainActivity.this, getNavigationItems());
        mNavigationDrawer.setAdapter(navigationAdapter);
        mNavigationDrawer.addOnItemSelectedListener(pos -> {
            NavigationItemModel item = navigationAdapter.getItem(pos);
            if (item != null) {
                Toast.makeText(MainActivity.this, item.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        mBtnHome.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Some text", Toast.LENGTH_LONG).show();
        });

        mBtnInfo.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, DetailsActivity.class));
        });

        mBtnList.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        });

        mBtnExit.setOnClickListener(view -> {
            MainActivity.this.finish();
        });
    }

    private ArrayList<NavigationItemModel> getNavigationItems() {
        ArrayList<NavigationItemModel> res = new ArrayList<NavigationItemModel>(3);

        res.add(new NavigationItemModel("First", "First item", R.drawable.ic_home));
        res.add(new NavigationItemModel("Second", "Second item", R.drawable.ic_list));
        res.add(new NavigationItemModel("Third", "Third item", R.drawable.ic_info));

        return res;
    }
}