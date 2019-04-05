package com.npe.artikelku.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.npe.artikelku.R;
import com.npe.artikelku.model.RiwayatModel;

import java.util.ArrayList;


public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.ViewHolder> {

    private ArrayList<RiwayatModel> dataList;
    Context context;

    public RiwayatAdapter(ArrayList<RiwayatModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.card_list_dompet_riwayat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvTanggal.setText(dataList.get(i).getTanggal());
        viewHolder.tvJudul.setText(dataList.get(i).getJudul());
        viewHolder.tvSaldo.setText(dataList.get(i).getSaldo());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal;
        TextView tvJudul;
        TextView tvSaldo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_tanggalDompetRiwayat);
            tvJudul = (TextView) itemView.findViewById(R.id.tv_judulDompetRiwayat);
            tvSaldo = (TextView) itemView.findViewById(R.id.tv_nominalDompetRiwayat);
        }


    }


}
