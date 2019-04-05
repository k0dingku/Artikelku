package com.npe.artikelku.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.npe.artikelku.R;
import com.npe.artikelku.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail, etPass;
    private Button btnLogin;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //bind
        etEmail = findViewById(R.id.etEmailLogin);
        etPass = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        //lvm
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);


        //btn login
        btnLogin.setOnClickListener(this);
    }

    private boolean validasiInput() {
        boolean valid = true;

        final String email = etEmail.getText().toString().trim();
        final String pass = etPass.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Masukkan Email Anda");
            etEmail.requestFocus();
            valid = false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Email tidak valid");
            etEmail.requestFocus();
            valid = false;
        }
        if (pass.isEmpty()) {
            etPass.setError("Masukkan Password Anda");
            etPass.requestFocus();
            valid = false;
        }
        if (pass.length() < 5) {
            etPass.setError("Password harus lebih dari 5 karakter");
            etPass.requestFocus();
            valid = false;
        }
        return valid;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
        }
    }

    private void login() {
        if (validasiInput()) {
            String email = etEmail.getText().toString();
            String pass = etPass.getText().toString();
            loginViewModel.init(email, pass);
        }

    }
}
