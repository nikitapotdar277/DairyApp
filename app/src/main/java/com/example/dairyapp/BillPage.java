package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BillPage extends AppCompatActivity {
    Button C_btn;
    Double total = 0.0;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference users = db.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_bill);

        ArrayList<Cart> finalCart = new ArrayList<>();

        Intent man = getIntent();
        String usnm = man.getStringExtra(LoginPage.Extra_String15);
        String usnm1 = man.getStringExtra(place_order.Extra_username);

        Header header = findViewById(R.id.header);
        header.initHeader();
        header.findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Cart1.class);
                i.putExtra(place_order.Extra_username, usnm);
                view.getContext().startActivity(i);
            }
        });
        header.findViewById(R.id.profile).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), UserProfile.class);
            intent.putExtra(MainActivity.Extra_username, usnm1);
            view.getContext().startActivity(intent);
        });

        Button C_btn = (Button)findViewById(R.id.C_btn);

        final EditText etxx = (EditText) findViewById(R.id.et_Final_Price);
        etxx.setEnabled(false);

        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(usnm1).exists()){
                    for (DataSnapshot data: snapshot.child(usnm1).child("Cart").getChildren()) {
                        Cart cart = data.getValue(Cart.class);
                        finalCart.add(cart);
                    }
                    for (int i=0; i<finalCart.size(); i++) {
                        total += Double.parseDouble(finalCart.get(i).gettotal1());
                    }

                    etxx.setText(total.toString());
                }
                else { System.out.println(usnm); }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        C_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
    }

    private void Logout()
    {

        Intent x = new Intent(this,LoginPage.class);
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show();
        startActivity(x);

        //System.exit(0);
    }
}
