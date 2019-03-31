package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.npe.artikelku.R;
import com.npe.artikelku.adapter.ArtikelAdapter;
import com.npe.artikelku.model.ArtikelModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtikelFragment extends Fragment {


    public ArtikelFragment() {
        // Required empty public constructor
    }

    ArrayList<ArtikelModel> artikelModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_artikel, container, false);

        SearchView searchView = (SearchView) v.findViewById(R.id.search_view_artikel);
        searchView.setQueryHint("cari artikelmu disini");

        addData();

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_artikelList);
        ArtikelAdapter artikelAdapter = new ArtikelAdapter(artikelModels, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(artikelAdapter);

        artikelAdapter.setOnClickListener(new ArtikelAdapter.onClickListener() {

            @Override
            public void onItemClick(View view, LinearLayout child,
                                    ImageView expand, int size, int pos) {


//                Log.i("DataKuu", "POS : " + String.valueOf(pos) +
//                        " Index : " + String.valueOf(i));

                if (child.getVisibility() == View.VISIBLE) {
                    child.setVisibility(View.GONE);
                    expand.setRotation(0);
                } else if (child.getVisibility() == View.GONE) {
                    child.setVisibility(View.VISIBLE);
                    expand.setRotation(180);
                }
                

//                if(child.getVisibility() == View.VISIBLE){
//                    child.setVisibility(View.GONE);
//                    expand.setRotation(0);
//                } else if(child.getVisibility() == View.GONE){
//                    child.setVisibility(View.VISIBLE);
//                    expand.setRotation(180);
//                }
            }
        });


        return v;
    }

    void addData() {
        artikelModels = new ArrayList<>();
        artikelModels.add(new ArtikelModel("Java Design Pattern"));
        artikelModels.add(new ArtikelModel("Java OOP"));
        artikelModels.add(new ArtikelModel("Android Constraint Layout"));
        artikelModels.add(new ArtikelModel("Android Date Picker"));
        artikelModels.add(new ArtikelModel("Pornhub.com"));
        artikelModels.add(new ArtikelModel("Java Design Pattern"));
        artikelModels.add(new ArtikelModel("Java OOP"));
        artikelModels.add(new ArtikelModel("Android Constraint Layout"));
        artikelModels.add(new ArtikelModel("Android Date Picker"));
        artikelModels.add(new ArtikelModel("Pornhub.com"));
    }

}
