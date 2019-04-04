package com.npe.artikelku;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.npe.artikelku.Fragment.BottomSheetPasswordDialog;
import com.npe.artikelku.R;

public class PasswordCheckActivity extends AppCompatActivity {

    LinearLayout layoutBottomPassword ;
    TextView tvLupaPassword;
    Button btnSubmit;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_check);
        btnSubmit = (Button) findViewById(R.id.btn_submit_cairkanDompet);
        btnOk = (Button) findViewById(R.id.btn_okay_cairkanDompet);
        tvLupaPassword = (TextView) findViewById(R.id.tv_resetPassword_passwordCheck);
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
                BottomSheetPasswordDialog bottomSheetPasswordDialog = new BottomSheetPasswordDialog();
                bottomSheetPasswordDialog.show(getSupportFragmentManager(),"passwordBottomSheet");
            }
        });

    }



}
