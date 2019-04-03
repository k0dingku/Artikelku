package com.npe.artikelku.respositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    public static LoginRepository instance;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public LiveData<LoginModel> loginUser(String email, String pass) {
        final MutableLiveData<LoginModel> data = new MutableLiveData<>();


        ApiClient.getApiInterface().getDataLogin(email, pass).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    //init data login model
                    if (response.body().getApi_status() == 1) {
                        data.setValue(response.body());
                    } else if (response.body().getApi_status() == 0) {
                        data.setValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.i("ErrorGetDataLogin", t.getMessage());
            }
        });

        return data;
    }

}
