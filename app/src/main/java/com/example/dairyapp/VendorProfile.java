package com.example.dairyapp;
import com.example.dairyapp.place_order;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class VendorProfile extends AppCompatActivity{
    FirebaseDatabase db;
    DatabaseReference vendor;
    ListView mainList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent main = getIntent();
        String someUser = main.getStringExtra(MainActivity.Extra_username);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        else {
            System.out.println(LoginPage.Extra_String12);
            System.out.println("Null haii");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);
        mainList = (ListView) findViewById(R.id.listview) ;
        db = FirebaseDatabase.getInstance();
        vendor = db.getReference("Vendor");
        System.out.println("Hello");
//        String currentUser = userinfo.uname;

        vendor.orderByChild("VendorUsername_reg").equalTo(someUser).addListenerForSingleValueEvent(
                new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        System.out.println("Will call ata");
                        showData(snapshot);
                        System.out.println("Called");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }

        );
    }
    private void showData(DataSnapshot snapshot) {
        System.out.println("Show Data Function");
        if (snapshot.hasChildren()) {
            System.out.println("bacche hai");
        }
        else {
            System.out.println("bacche hai hi nahi");
        }
        for(DataSnapshot datas: snapshot.getChildren()){
            String username =datas.child("VendorUsername_reg").getValue().toString();
            String name =datas.child("VendorFirstName").getValue().toString() + " " + datas.child("VendorLastName").getValue().toString();
            String address =datas.child("VendorDairyAddress").getValue().toString();
            String phone_no = datas.child("VendorMobile").getValue().toString();
            String email=datas.child("VendorEmailID").getValue().toString();

            ArrayList<String> array = new ArrayList<>();
            array.add(username);
            array.add(name);
            array.add(address);
            array.add(phone_no);
            array.add(email);
            System.out.println(name);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,array);
            mainList.setAdapter(adapter);
        }
    }

}
