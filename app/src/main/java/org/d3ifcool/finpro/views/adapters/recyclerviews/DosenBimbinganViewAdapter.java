package org.d3ifcool.finpro.views.adapters.recyclerviews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.d3ifcool.finpro.R;
import org.d3ifcool.finpro.models.dataclass.Bimbingan;
import org.d3ifcool.finpro.views.activities.details.DosenBimbinganDetailActivity;
import org.d3ifcool.finpro.views.activities.details.MahasiswaJudulPaDosenDetailActivity;

import java.util.ArrayList;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 27/01/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */
public class DosenBimbinganViewAdapter extends RecyclerView.Adapter<DosenBimbinganViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Bimbingan> data;
    private int layoutType;

    public DosenBimbinganViewAdapter(Context context) {
        this.context = context;
    }

    public void addItem(ArrayList<Bimbingan> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setLayoutType(int mLayoutType){
        this.layoutType = mLayoutType;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView infoIsi, infoTanggal;

        public ViewHolder(View itemView) {
            super(itemView);
            // -------------------------------------------------------------------------------------
            infoIsi = itemView.findViewById(R.id.ctn_mhs_pa_bimbingan_textview_isi);
            infoTanggal = itemView.findViewById(R.id.ctn_mhs_pa_bimbingan_textview_tanggal);
            // -------------------------------------------------------------------------------------
        }
    }

    @Override
    public void onBindViewHolder(final DosenBimbinganViewAdapter.ViewHolder holder, final int position) {
        holder.infoTanggal.setText(data.get(position).getTanggal());
        holder.infoIsi.setText(data.get(position).getIsi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentData = new Intent(context, DosenBimbinganDetailActivity.class);
                context.startActivity(intentData);
            }
        });
    }

    @NonNull
    @Override
    public DosenBimbinganViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        return new DosenBimbinganViewAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}