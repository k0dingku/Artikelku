package com.npe.artikelku.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.npe.artikelku.Fragment.BottomSheetPasswordDialog;
import com.npe.artikelku.R;
import com.npe.artikelku.presenter.KonfirmasiPasswordCairkanResultCallbacks;

import es.dmoral.toasty.Toasty;

public class PasswordCheckActivity extends AppCompatActivity implements KonfirmasiPasswordCairkanResultCallbacks {

    LinearLayout layoutBottomPassword;
    TextView tvLupaPassword;
    Button btnSubmit;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_check);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        getSupportActionBar().setTitle("Konfirmasi Password");


        btnSubmit = (Button) findViewById(R.id.btn_submit_cairkanDompet);
        btnOk = (Button) findViewById(R.id.btn_okay_cairkanDompet);
        tvLupaPassword = (TextView) findViewById(R.id.tv_lupaPassword_passwordCheck);
        tvLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordCheckActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        layoutBottomPassword = findViewById(R.id.bottom_sheet_password);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSucces("Saldo anda segera kami proses");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onSucces(String msg) {
        Toasty.success(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        Toasty.error(this, msg, Toast.LENGTH_SHORT).show();
    }
}
