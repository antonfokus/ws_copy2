package com.learn.wearexample1.ui.details;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import com.learn.wearexample1.databinding.ActivityDetailsBinding;

public class DetailsActivity extends Activity {

    private TextView mTextView;
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mTextView = binding.text;
    }
}