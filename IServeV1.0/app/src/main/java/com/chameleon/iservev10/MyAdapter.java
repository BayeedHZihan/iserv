package com.chameleon.iservev10;


import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    private List<Category> moviesList;
    Context ctx;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public TextView txtMenuName;
        public ImageView imageView;
        private ItemClickListener itemClickListener;


        public MyViewHolder(View view) {
            super(view);

            txtMenuName = (TextView) itemView.findViewById(R.id.menu_name);
           // imageView = (ImageView) itemView.findViewById(R.id.menu_image);
        }


        @Override
        public void onClick(View v) {

        }
    }


    public MyAdapter(List<Category> moviesList, Context ctx) {
        this.moviesList = moviesList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category movie = moviesList.get(position);
        holder.txtMenuName.setText(movie.getName());


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}