package com.learn.wearexample1.ui.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.learn.wearexample1.model.ListItemModel;
import com.learn.wearexample1.databinding.ActivityListBinding;

import java.util.ArrayList;

public class ListActivity extends Activity {

    private WearableRecyclerView mRecyclerView;
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mRecyclerView = binding.recyclerView;

        ListItemAdapter adapter = new ListItemAdapter(getList(100));

        mRecyclerView.setLayoutManager(new WearableLinearLayoutManager(ListActivity.this));
        mRecyclerView.setAdapter(adapter);
        //mRecyclerView.setCircularScrollingGestureEnabled(true);
        mRecyclerView.setEdgeItemsCenteringEnabled(true);

        mRecyclerView.setOnGenericMotionListener((v, ev) -> {
            if (ev.getAction() == MotionEvent.ACTION_SCROLL &&
                    ev.isFromSource(InputDeviceCompat.SOURCE_ROTARY_ENCODER)
            ) {
                // Don't forget the negation here
                float delta = -ev.getAxisValue(MotionEventCompat.AXIS_SCROLL) *
                        ViewConfigurationCompat.getScaledVerticalScrollFactor(
                                ViewConfiguration.get(ListActivity.this), ListActivity.this
                        );

                v.scrollBy(0, Math.round(delta));

                return true;
            }
            return false;
        });
    }

    private ArrayList<ListItemModel> getList(int count) {
        ArrayList<ListItemModel> res = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            res.add(i, new ListItemModel(i, new StringBuilder("List Item #").append(i).toString()));
        }

        return res;
    }
}