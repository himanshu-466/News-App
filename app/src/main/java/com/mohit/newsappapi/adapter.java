package com.mohit.newsappapi;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
ArrayList<ModelClass> model;
Context context;

    public adapter(ArrayList<ModelClass> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.samplelayout,parent,false);
        return  new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull adapter.viewholder holder, int position) {
        ModelClass data = model.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webview.class);
                intent.putExtra("url",model.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.date.setText("Published At :"+model.get(position).getAuthor());
        holder.author.setText(model.get(position).getAuthor());
        holder.content.setText(model.get(position).getContent());
        holder.heading.setText(model.get(position).getTitle());

        Glide.with(context).load(model.get(position).getUrlToImage()).into(holder.contentimage);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView  contentimage;
        TextView heading,content,author,date;
        CardView cardView;
        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            contentimage = itemView.findViewById(R.id.contentImage);
            heading = itemView.findViewById(R.id.heading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }


}
