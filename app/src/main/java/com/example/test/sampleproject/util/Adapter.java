package com.example.test.sampleproject.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.sampleproject.R;
import com.example.test.sampleproject.model.Music;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
private Context context;
private List<Music> list;

    public Adapter(Context context, List<Music> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.model,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
Music music=list.get(i);
myViewHolder.iso.setText(music.getIso());
myViewHolder.name.setText(music.getName());
myViewHolder.phone.setText(music.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
      private   TextView iso;
      private   TextView name;
      private   TextView phone;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            iso=itemView.findViewById(R.id.iso);
            name=itemView.findViewById(R.id.name);
            phone=itemView.findViewById(R.id.phone);
        }
    }
}
