package com.example.dairyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class VendorHome extends AppCompatActivity {

    Switch availibility;
   RecyclerView recview;
    vendoradapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recview = (RecyclerView)findViewById(R.id.recyclerview);
        recview.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vendor").child("xyz"), model.class)
                        .build();


        adapter = new vendoradapter(options);
        recview.setAdapter(adapter);





        availibility = (Switch)findViewById(R.id.service_availability);
//        SharedPreferences sharedPreferences = getSharedPreferences("save",MODE_PRIVATE);
//        availibility.setChecked(sharedPreferences.getBoolean("value",true));
//
//        availibility.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (availibility.isChecked()){
//                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
//                    editor.putBoolean("value",true);
//                    editor.apply();
//                    availibility.setChecked(true);
//                }
//                else {
//                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
//                    editor.putBoolean("value",false);
//                    editor.apply();
//                    availibility.setChecked(false);
//                }
//
////           availibility_func();
//
//            }
//        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void availibility_func() {

        Map<String,Object> map = new HashMap<>();
        map.put("availibility",availibility.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("Vendor")
                .child("lola").child("availability")
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        availibility.setText("True");
                        Toast.makeText(getApplicationContext(),"Updated Availability Successfully",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                availibility.setText("False");
                Toast.makeText(getApplicationContext(),"Could not update  availability",Toast.LENGTH_LONG).show();
            }
        });
    }
}