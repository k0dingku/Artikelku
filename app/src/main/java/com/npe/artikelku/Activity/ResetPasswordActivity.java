package com.npe.artikelku.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.npe.artikelku.R;
import com.npe.artikelku.presenter.LupaPasswordResultCallbacks;

import es.dmoral.toasty.Toasty;

public class ResetPasswordActivity extends AppCompatActivity implements LupaPasswordResultCallbacks {

    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        getSupportActionBar().setTitle("Lupa Password");

        btn_submit = (Button) findViewById(R.id.btn_submit_lupaPassword);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSucces("Silahkan periksa email anda");
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
    public void onSucces(String msg) {
        Toasty.info(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailed(String msg) {
        Toasty.error(this, msg, Toast.LENGTH_SHORT).show();
    }
}
