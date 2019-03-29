package com.npe.artikelku.rest;

import com.npe.artikelku.model.LoginModel;
import com.npe.artikelku.model.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("pengguna_login")
    Call<LoginModel> getDataLogin(@Body RequestLogin requestLogin);
}
