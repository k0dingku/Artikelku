package com.npe.artikelku.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.npe.artikelku.R;
import com.npe.artikelku.databinding.ActivityLoginBinding;
import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.model.user.UserModel;
import com.npe.artikelku.presenter.LoginResultCallbacks;
import com.npe.artikelku.viewmodel.LoginViewModel;
import com.npe.artikelku.viewmodel.LoginViewModelFactory;
import com.npe.artikelku.viewmodel.UserViewModel;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this)).get(LoginViewModel.class));

    }


    public void mainAcitivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    public void dataUser(LoginModel loginModel) {

        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.insert(new UserModel(loginModel.getId(), loginModel.getNama(),
                loginModel.getEmail(), loginModel.getNoHp(), loginModel.getGender(),
                loginModel.getBank(), loginModel.getNomor_rekening(), loginModel.getNama_rekening()));

        Log.i("DataEmail", loginModel.getEmail());

        //toMain
        mainAcitivity();
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
