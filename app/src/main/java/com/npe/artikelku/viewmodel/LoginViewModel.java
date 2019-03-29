package com.npe.artikelku.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.npe.artikelku.methodInterface.LoginResultCallbacks;
import com.npe.artikelku.model.RequestLogin;

public class LoginViewModel extends ViewModel {
    private RequestLogin requestLogin;
    private LoginResultCallbacks loginResultCallbacks;


    public LoginViewModel(LoginResultCallbacks loginResultCallbacks){
        this.loginResultCallbacks = loginResultCallbacks;
        this.requestLogin = new RequestLogin();
    }

    //get email dan pass from et
    public TextWatcher getEmailTextWatcher(){
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
    public TextWatcher getPasswordTextWatcher(){
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

    //proses login
    public void onLoginClick(View view){
        int errorCode = requestLogin.isValidData();
        if(errorCode == -1){
            loginResultCallbacks.onSuccess("Login Success");
        } else if(errorCode == 0) {
            loginResultCallbacks.onFailed("Empety email");
        } else if(errorCode == 1){
            loginResultCallbacks.onFailed("Email not valid");
        } else if( errorCode == 2){
            loginResultCallbacks.onFailed("pasword must more than 6 character");
        }
    }

}
