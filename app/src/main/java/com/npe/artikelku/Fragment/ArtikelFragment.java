package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import com.npe.artikelku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {


    public ArtikelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_artikel, container, false);



        return v;
    }

}
