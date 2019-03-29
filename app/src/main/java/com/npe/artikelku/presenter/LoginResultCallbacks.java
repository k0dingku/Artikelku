package com.npe.artikelku.presenter;

import com.npe.artikelku.model.LoginModel;

public interface LoginResultCallbacks {
    void onSuccess(String msg);
    void mainAcitivity();
    void onFailed(String msg);
}
