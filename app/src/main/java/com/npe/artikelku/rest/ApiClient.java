package com.npe.artikelku.rest;

import com.npe.artikelku.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit.Builder retfotitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retfotitBuilder.build();
    private static ApiInterface apiInterface = retrofit.create(ApiInterface.class);

    public static ApiInterface getApiInterface() {
        return apiInterface;
    }


}
