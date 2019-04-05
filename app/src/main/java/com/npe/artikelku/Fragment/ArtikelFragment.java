package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

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
    String posOld;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_artikel, container, false);

        SearchView searchView = (SearchView) v.findViewById(R.id.search_view_artikel);
        searchView.setQueryHint("cari artikelmu disini");

        searchView.setFocusable(false);

        addData();

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_artikelList);
        final ArtikelAdapter artikelAdapter = new ArtikelAdapter(artikelModels, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(artikelAdapter);

        artikelAdapter.setOnClickListener(new ArtikelAdapter.onClickListener() {

            @Override
            public void onItemClick(View view, ArrayList<ArtikelModel> models, LinearLayout child,
                                    ImageView expand, int size, int pos) {
                for (int i = 0; i < size; i++) {
                    if (pos == i) {
                        if (models.get(i).isExpand()) {
                            models.get(i).collapse();
                        } else {
                            models.get(i).expanded();
                        }
                        continue;
                    }
                    models.get(i).collapse();
                }

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
