package com.npe.artikelku.viewmodel;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.npe.artikelku.model.RequestLogin;
import com.npe.artikelku.presenter.LoginResultCallbacks;
import com.npe.artikelku.respositories.LoginRepository;
import com.npe.artikelku.utils.Constant;

public class LoginViewModel extends ViewModel {
    private RequestLogin requestLogin;
    private LoginResultCallbacks loginResultCallbacks;
    private LoginRepository loginRepository;
    private ProgressDialog progressDialog;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        loginRepository = LoginRepository.getInstance();
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
            //progress dialog
            progressDialog = Constant.getDialog(view.getContext());
            //send and get login data
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


    //proses login
    private void sendLoginRequest() {
        String email = requestLogin.getEmail().trim();
        String pass = requestLogin.getPassword().trim();
        Log.i("EmailPass", "Email : " + email + " Pass : " + pass);
        //show progress
        progressDialog.show();
        //login request
        loginRepository.loginUser(email, pass);

        if (loginRepository.loginUser(email, pass) != null) {
            loginResultCallbacks.onSuccess("Berhasil Login");
            progressDialog.dismiss();
            loginResultCallbacks.dataUser(loginRepository.loginUser(email, pass));
        } else if (loginRepository.loginUser(email, pass) == null) {
            progressDialog.dismiss();
            loginResultCallbacks.onFailed("Gagal Login");
        }
    }
}
