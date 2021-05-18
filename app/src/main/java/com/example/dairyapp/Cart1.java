package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Cart1 extends AppCompatActivity {
    Collection<Map<String,String>> cart = new HashSet<Map<String,String>>();
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart1);

        Intent main = getIntent();
        String name = main.getStringExtra(place_order.Extra_username);
        String name_carrier = name;

        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        ArrayList<Cart> cartItems = new ArrayList<Cart>();
        ArrayList<Cart> cartItems1 = new ArrayList<Cart>();

        Header header = findViewById(R.id.header);
        header.initHeader();
        header.findViewById(R.id.profile).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), UserProfile.class);
            intent.putExtra(MainActivity.Extra_username, name);
            view.getContext().startActivity(intent);
        });

        RecyclerView recyclerView = findViewById(R.id.cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        RecyclerView cartItems = (RecyclerView) findViewById(R.id.cartItems);

        System.out.println("name");
        System.out.println(name);

        users.orderByChild("username_reg").equalTo(name).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                System.out.println("Change toh hua");
                for (DataSnapshot data: snapshot.child("Cart").getChildren()) {
                    Cart cart = data.getValue(Cart.class);
                    System.out.println("FOR LOOP");
                    cartItems.add(cart);
                }
                System.out.println("cartItems");
                System.out.println(cartItems);
                CartAdapter adapter = new CartAdapter(cartItems);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.child("Cart").getChildren()) {
                    Cart cart = data.getValue(Cart.class);

                }
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }



        });

        Button addItemsToCart = findViewById(R.id.addbtn);
        addItemsToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                i.putExtra(LoginPage.Extra_String15, name_carrier);
                view.getContext().startActivity(i);
            }
        });

        Button order = findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BillPage.class);
                intent.putExtra(place_order.Extra_username, name_carrier);
                view.getContext().startActivity(intent);

            }
        });
    }
}
