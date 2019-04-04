package com.npe.artikelku.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.npe.artikelku.model.ArtikelModel;
import com.npe.artikelku.model.StatusModel;
import com.npe.artikelku.R;
import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private ArrayList<StatusModel> statusModels;
    private onClickListener onClickListener;
    Context context;

    public StatusAdapter(ArrayList<StatusModel> statusModels, Context context) {
        this.statusModels = statusModels;
        this.context = context;
    }

    @NonNull
    @Override
    public StatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view =layoutInflater.inflate(R.layout.card_list_dompet_status, viewGroup, false);
        return new StatusAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvTanggal.setText(statusModels.get(i).getTanggal());
        viewHolder.tvJudul.setText(statusModels.get(i).getJudul());
        viewHolder.tvStatus.setText(statusModels.get(i).getStatus());

        if (statusModels.get(i).isExpand()){
            viewHolder.linearLayoutChild.setVisibility(View.VISIBLE);
            viewHolder.ivArrow.setRotation(180);
        }
        else {
            viewHolder.linearLayoutChild.setVisibility(View.GONE);
            viewHolder.ivArrow.setRotation(0);
        }


    }

    @Override
    public int getItemCount() {
        return statusModels.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal;
        TextView tvJudul;
        TextView tvStatus;
        ImageView ivArrow;
        LinearLayout linearLayoutChild;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = (TextView) itemView.findViewById(R.id.tv_tanggal_dompetStatus);
            tvJudul = (TextView) itemView.findViewById(R.id.tv_namaStatus_dompetStatus);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status_dompetStatus);
            ivArrow = (ImageView) itemView.findViewById(R.id.iv_dropDown_dompetStatus);
            linearLayoutChild = itemView.findViewById(R.id.liner_layout2_dompetStatus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onClickListener.onItemClick(v, statusModels, linearLayoutChild, ivArrow, statusModels.size()
                                , position);
                    }
                    notifyDataSetChanged();
                }
            });

        }
    }
    public interface onClickListener {
        void onItemClick(View view, ArrayList<StatusModel> statusModels, LinearLayout linearLayoutChild, ImageView ivArrow, int size, int position);
    }
    public void setOnClickListener(StatusAdapter.onClickListener onClickListener) {
        this.onClickListener = (StatusAdapter.onClickListener) onClickListener;
    }

}
