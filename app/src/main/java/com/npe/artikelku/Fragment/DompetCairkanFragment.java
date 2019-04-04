package com.npe.artikelku.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.npe.artikelku.PasswordCheckActivity;
import com.npe.artikelku.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DompetCairkanFragment extends Fragment {

    Button btnCairkan;


    public DompetCairkanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_dompet_cairkan, container, false);
        Button btnCairkan = (Button) view.findViewById(R.id.btn_cairkan_DompetCairkan);
        btnCairkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PasswordCheckActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
