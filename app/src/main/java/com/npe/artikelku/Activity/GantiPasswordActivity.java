package com.npe.artikelku.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.npe.artikelku.R;
import com.npe.artikelku.presenter.GantiPasswordResultCallbacks;

import es.dmoral.toasty.Toasty;

public class GantiPasswordActivity extends AppCompatActivity implements GantiPasswordResultCallbacks {

    Button ganti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        getSupportActionBar().setTitle("Ganti Password");

        ganti = findViewById(R.id.btn_gantiPassword);

        ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSucces("Password andah telah diganti");
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
