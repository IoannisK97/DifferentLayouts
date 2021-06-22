package com.example.jandroid.differentlayouts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Animal> animalList=new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            picture=(ImageView) view.findViewById(R.id.image);
        }

        public void bind() {
            Animal animalTemp = animalList.get(getAdapterPosition());
            name.setText(animalTemp.getName());
            picture.setImageResource(animalTemp.getPicture());
        }
    }

    public AnimalAdapter(List<Animal> animalList ){
        this.animalList=animalList;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_element, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).bind();
        }

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
