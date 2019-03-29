package com.npe.artikelku.respositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.model.RequestLogin;
import com.npe.artikelku.rest.ApiClient;
import com.npe.artikelku.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepository {
    public static LoginRepository instance;
    private LoginModel loginData;
    //retrofit
    private Retrofit retrofit;
    private ApiInterface apiInterface;

    public void initRetrofit() {
        retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    public MutableLiveData<LoginModel> getDataLogin(String email, String password) {
        MutableLiveData<LoginModel> dataLogin = new MutableLiveData<>();
        //requet login
        RequestLogin requestLogin = new RequestLogin(email, password);

        apiInterface.getDataLogin(requestLogin).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                LoginModel data = response.body();
                if (data != null) {
                    initDataLogin(data);
                    Log.i("InterfaceLogin", "Masuk");
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Log.i("ErrorLogin", t.getMessage());
            }
        });
        dataLogin.setValue(loginData);
        return dataLogin;
    }

    private void initDataLogin(LoginModel data) {
        String id = data.getId();
        String nama = data.getNama();
        String email = data.getEmail();
        String noHp = data.getNoHp();
        String gender = data.getGender();
        String bank = data.getBank();
        String nomor_rekening = data.getNomor_rekening();
        String nama_rekening = data.getNama_rekening();
        loginData = new LoginModel(id, nama, email, noHp, gender, bank, nomor_rekening, nama_rekening);

        Log.i("DataLogin", String.valueOf(loginData.getEmail()));
    }
}
