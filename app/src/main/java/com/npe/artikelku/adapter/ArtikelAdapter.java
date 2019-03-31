package com.npe.artikelku.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.npe.artikelku.R;
import com.npe.artikelku.model.ArtikelModel;

import java.util.ArrayList;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.ViewHolder> {

    private ArrayList<ArtikelModel> dataList;
    private onClickListener onClickListener;
    Context context;


    public ArtikelAdapter(ArrayList<ArtikelModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_list_artikel, viewGroup, false);
        return new ViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.tv_title.setText(dataList.get(i).getJudul());
        if (dataList.get(i).isExpand()){
            viewHolder.child.setVisibility(View.VISIBLE);
            viewHolder.expand.setRotation(180);
        }
        else {
            viewHolder.child.setVisibility(View.GONE);
            viewHolder.expand.setRotation(0);
        }
        Glide.with(context)
                .load(R.drawable.ic_expand_more)
                .into(viewHolder.expand);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView expand;
        //        View parent;
        LinearLayout child;

        public ViewHolder(View itemView, final onClickListener onClickListener) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.title_card);
            expand = (ImageView) itemView.findViewById(R.id.expand_arrow);
//            parent = itemView.findViewById(R.id.linear_layout_1);
            child = itemView.findViewById(R.id.liner_layout_2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        onClickListener.onItemClick(v, dataList,child, expand, dataList.size()
                        , position);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface onClickListener {
        void onItemClick(View view, ArrayList<ArtikelModel> models, LinearLayout child, ImageView expand, int size
                , int position);
    }

    public void setOnClickListener(onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


}
