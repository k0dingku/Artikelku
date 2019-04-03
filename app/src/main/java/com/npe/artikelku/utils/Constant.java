package com.npe.artikelku.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import com.npe.artikelku.R;

public class Constant {
    public static final String BASE_URL = "http://artikelku.kodingku.net/api/";
    public static final String PENGGUNA_LOGIN = "pengguna_login";
    public static final int NETWORK_TIMEOUT = 3000;


    public static ProgressDialog getDialog(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.FullScreen) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.progress_dialog);
                getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
        };

        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
