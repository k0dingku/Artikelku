package com.npe.artikelku.respositories;

import android.util.Log;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.rest.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    public static LoginRepository instance;
    private LoginModel data;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public LoginModel loginUser(String email, String pass) {
        ApiClient.getApiInterface().getDataLogin(email, pass).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.body() != null) {
                    //init data login model
                    if (response.body().getApi_message().equalsIgnoreCase("success")) {
                        data = response.body();
                        Log.i("ResponDataLogin", "Masuk");

                    } else {
                        data = null;
                        Log.i("ResponDataLogin", "Null");

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
