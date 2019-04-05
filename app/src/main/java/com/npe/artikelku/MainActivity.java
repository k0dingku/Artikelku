package com.npe.artikelku;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.npe.artikelku.model.user.UserModel;
import com.npe.artikelku.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    TextView tvCoba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCoba = findViewById(R.id.tvCoba);

        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.getAllUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel userModel) {
                tvCoba.setText(String.valueOf(userModel.getNama()));
            }
        });
    }
}
