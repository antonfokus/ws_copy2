package com.learn.wearexample1.ui.signin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.learn.wearexample1.R;
import com.learn.wearexample1.databinding.ActivitySignInBinding;
import com.learn.wearexample1.ui.main.MainActivity;

public class SignInActivity extends Activity {

    private ImageView mImgLogo;
    private EditText mEdtLogin;
    private EditText mEdtPassword;
    private Button mBtnSignIn;
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.DefaultTheme);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mImgLogo = binding.imgLogo;
        mEdtLogin = binding.edtLogin;
        mEdtPassword = binding.edtPassword;
        mBtnSignIn = binding.btnSignIn;

        mBtnSignIn.setOnClickListener(view -> {
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            SignInActivity.this.finish();
        });
    }
}