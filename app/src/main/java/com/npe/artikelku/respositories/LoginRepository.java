package com.npe.artikelku.respositories;

import com.npe.artikelku.rest.ApiClient;

public class LoginRepository {
    public static LoginRepository instance;
    private ApiClient mApiClient;

    public static LoginRepository getInstance(){
        if(instance == null){
            instance = new LoginRepository();
        }
        return instance;
    }
}
