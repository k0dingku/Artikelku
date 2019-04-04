package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.npe.artikelku.R;
import com.npe.artikelku.adapter.RiwayatAdapter;
import com.npe.artikelku.model.RiwayatModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DompetRiwayatFragment extends Fragment {


    public DompetRiwayatFragment() {
        // Required empty public constructor
    }
    ArrayList<RiwayatModel> riwayatModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dompet_riwayat, container, false);
        riwayatModels.add(new RiwayatModel("04/03/2019", "Penarikan Saldo", "-Rp 100.000"));
        riwayatModels.add(new RiwayatModel("05/03/2019", "Reward artikel Abstract Class", "+Rp 10.000"));
        riwayatModels.add(new RiwayatModel("05/03/2019", "Reward artikel Abstract Class", "+Rp 10.000"));


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dompetRiwayat);
        final RiwayatAdapter riwayatAdapter = new RiwayatAdapter(riwayatModels,getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(riwayatAdapter);
        return view;
    }

}
