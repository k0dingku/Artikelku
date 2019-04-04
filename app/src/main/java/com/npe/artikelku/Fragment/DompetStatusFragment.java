package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.npe.artikelku.R;
import com.npe.artikelku.adapter.StatusAdapter;
import com.npe.artikelku.model.StatusModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DompetStatusFragment extends Fragment {

    ArrayList<StatusModel> statusModels = new ArrayList<>();

    public DompetStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dompet_status, container, false);
        statusModels.add(new StatusModel("14/03/2019", "Pencairan Saldo", "Proses Pengiriman"));
        statusModels.add(new StatusModel("15/03/2019", "Pencairan Saldo", "Telah dikirimkan"));
        statusModels.add(new StatusModel("16/03/2019", "Pencairan Saldo", "Proses Pengiriman"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dompetStatus);
        final StatusAdapter statusAdapter = new StatusAdapter(statusModels, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(statusAdapter);
        statusAdapter.setOnClickListener(new StatusAdapter.onClickListener() {
            @Override
            public void onItemClick(View view, ArrayList<StatusModel> statusModels, LinearLayout linearLayoutChild, ImageView ivArrow, int size, int position) {
                for (int i=0;i<size;i++){
                    if (position==i){
                        if (statusModels.get(i).isExpand()){
                            statusModels.get(i).collapse();
                        }
                        else {
                            statusModels.get(i).expanded();
                        }
                        continue;
                    }
                    statusModels.get(i).collapse();
                }
            }
        });
        return view;
    }

}
