package org.d3ifcool.superuser.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.d3ifcool.service.models.Dosen;
import org.d3ifcool.superuser.R;
import org.d3ifcool.superuser.activities.details.KoorDosenDetailActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

import static org.d3ifcool.service.network.ApiUrl.FinproUrl.URL_FOTO_DOSEN;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Finpro
 * Copyright (C) 08/03/2019.
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
public class KoorDosenViewAdapter extends RecyclerView.Adapter<KoorDosenViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Dosen> dosens;
    private int layoutType;

    public KoorDosenViewAdapter(Context context) {
        this.context = context;
    }


    public void setDosens(ArrayList<Dosen> dosens) {
        this.dosens = dosens;
    }


    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layoutType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nama_dosen.setText(dosens.get(position).getNama_d());
        holder.nip_dosen.setText(dosens.get(position).getNip_dosen());
        holder.bimbing.setText("6");
        Picasso.get().load(URL_FOTO_DOSEN+dosens.get(position).getFoto()).into(holder.foto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KoorDosenDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dosens.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama_dosen, nip_dosen, bimbing;
        CircleImageView foto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_dosen = itemView.findViewById(R.id.ctn_koor_textview_nama_dosen);
            nip_dosen = itemView.findViewById(R.id.ctn_koor_dosen_nip);
            foto = itemView.findViewById(R.id.ctn_koor_dosen_circle_image);
            bimbing = itemView.findViewById(R.id.ctn_koor_dosen_bimbing);

        }
    }
}