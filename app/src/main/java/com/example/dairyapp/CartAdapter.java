package com.example.dairyapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference users = db.getReference("Users");

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView productName;
        public TextView productPrice;
        public TextView date;
        public String user;
        int position;
        Cart currentCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Log.d("ViewHolder", "called");

            productName = (TextView) itemView.findViewById(R.id.product);
            productPrice = (TextView) itemView.findViewById(R.id.price);
            date = (TextView) itemView.findViewById(R.id.date);
            itemView.findViewById(R.id.delbt).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myCart.remove(position);
                    notifyItemRemoved(position);
                    users.child(currentCart.getUname()).child("Cart").child(currentCart.getDate()).removeValue();
                }
            });
        }
    }

    private List<Cart> myCart;

    public CartAdapter(List<Cart> cart) {
        myCart = cart;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("OnCreateViewHolder", "called");

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View cartView = inflater.inflate(R.layout.cart, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(cartView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("onBindViewHolder", "called");

        Cart cart = myCart.get(position);
    TextView productView = holder.productName;
    productView.setText(cart.getitem1());
    TextView priceView = holder.productPrice;
    priceView.setText(cart.gettotal1());
    TextView textView = holder.date;
    textView.setText(cart.getDate());
    holder.user = cart.getUname();
    holder.position = position;
    holder.currentCart = cart;
    }

    @Override
    public int getItemCount() {
        Log.i("getItemCount", "called");
        return myCart.size();
    }
}
