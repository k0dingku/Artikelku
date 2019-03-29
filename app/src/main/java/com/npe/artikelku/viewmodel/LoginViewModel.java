package com.npe.artikelku.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.respositories.LoginRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<LoginModel> mLoginModel;
    private LoginRepository loginRepository;

    public void init(String email, String password) {
        if (mLoginModel != null) {
            Log.i("LoginViewModel", "LoginDataAda");
            return;
        }

        loginRepository = LoginRepository.getInstance();
        loginRepository.initRetrofit();
        mLoginModel = loginRepository.getDataLogin(email,password);
    }

    public LiveData<LoginModel> getLoginData(){
        return mLoginModel;
    }
}
