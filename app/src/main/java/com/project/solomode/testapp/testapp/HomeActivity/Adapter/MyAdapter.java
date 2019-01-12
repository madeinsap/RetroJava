package com.project.solomode.testapp.testapp.HomeActivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.solomode.testapp.testapp.HomeActivity.Model.Instansi;
import com.project.solomode.testapp.testapp.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Instansi> instansiList;

    public MyAdapter(ArrayList<Instansi> instansiList) {
        this.instansiList = instansiList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_instansi, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.instansi.setText(instansiList.get(position).getInstansi());
        holder.alamat.setText(instansiList.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return instansiList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView instansi;
        TextView alamat;

        MyViewHolder(View itemView) {
            super(itemView);
            instansi = itemView.findViewById(R.id.txtInstansi);
            alamat = itemView.findViewById(R.id.txtAlamat);
        }
    }
}
