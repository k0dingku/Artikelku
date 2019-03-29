package com.npe.artikelku;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.npe.artikelku.databinding.ActivityLoginBinding;
import com.npe.artikelku.methodInterface.LoginResultCallbacks;
import com.npe.artikelku.viewmodel.LoginViewModel;
import com.npe.artikelku.viewmodel.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));
    }


    @Override
    public void onSuccess(String msg) {
        Toasty.success(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        Toasty.error(this, msg, Toast.LENGTH_SHORT).show();
    }
}
