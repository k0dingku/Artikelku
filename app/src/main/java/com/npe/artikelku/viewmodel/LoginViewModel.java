package com.npe.artikelku.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.model.RequestLogin;
import com.npe.artikelku.presenter.LoginResultCallbacks;
import com.npe.artikelku.rest.ApiClient;
import com.npe.artikelku.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends ViewModel {
    private RequestLogin requestLogin;
    private LoginResultCallbacks loginResultCallbacks;
    private Retrofit retrofit;
    private ApiInterface service;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.requestLogin = new RequestLogin();
    }

    //get email dan pass from et
    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                requestLogin.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                requestLogin.setPassword(s.toString());
            }
        };
    }

    //valid login
    public void onLoginClick(View view) {
        int errorCode = requestLogin.isValidData();
        if (errorCode == -1) {
            sendLoginRequest();
        } else if (errorCode == 0) {
            loginResultCallbacks.onFailed("Empety email");
        } else if (errorCode == 1) {
            loginResultCallbacks.onFailed("Email not valid");
        } else if (errorCode == 2) {
            loginResultCallbacks.onFailed("Empety password");
        } else if (errorCode == 3) {
            loginResultCallbacks.onFailed("pasword must more than 6 character");
        }
    }

    //init retrofit
    private void initRetrofit() {
        retrofit = ApiClient.getClient();
        service = retrofit.create(ApiInterface.class);
    }

    //proses login
    public void sendLoginRequest() {
        initRetrofit();

        service.getDataLogin(requestLogin.getEmail(), requestLogin.getPassword()).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    //init data login model
                    if (response.body().getApi_status() == 1) {
                        initDataUser(response.body());
                        loginResultCallbacks.mainAcitivity();
                    } else if(response.body().getApi_status() == 0){
                        loginResultCallbacks.onFailed("Username or password invalid. Please try again");
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                loginResultCallbacks.onFailed("Failed Login");
            }
        });

    }

    private void initDataUser(LoginModel body) {
        loginResultCallbacks.onSuccess("Login Success Email : " + String.valueOf(body.getEmail()));
    }
}
