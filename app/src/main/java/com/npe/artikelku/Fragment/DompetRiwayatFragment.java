package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.npe.artikelku.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DompetRiwayatFragment extends Fragment {


    public DompetRiwayatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dompet_riwayat, container, false);
    }

}
