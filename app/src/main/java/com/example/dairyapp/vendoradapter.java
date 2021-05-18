package com.example.dairyapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.CircledImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class vendoradapter extends FirebaseRecyclerAdapter<model,vendoradapter.myviewholder>
{
    public vendoradapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.user.setText(model.getName().toString());
        holder.product.setText(model.getProduct().toString());
        holder.total.setText(model.getTotal().toString());
//        holder.img.setImageResource(model.ge);
//        Glide.with(holder.img.getContext()).load( )
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_user,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
//        CircledImageView img;
        TextView product,user,total;
        public myviewholder(@NonNull View itemView) {
            super(itemView);


//            img = (CircledImageView) itemView.findViewById(R.id.img1);
            user = (TextView) itemView.findViewById(R.id.usertext);
            product = (TextView) itemView.findViewById(R.id.producttext);
            total = (TextView) itemView.findViewById(R.id.totaltext);

        }
    }
}
