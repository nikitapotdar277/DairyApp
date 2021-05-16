package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class MyOrder extends AppCompatActivity{

    ListView listView;
    FirebaseDatabase db;
    DatabaseReference users2;
    ArrayList<String>list;
    ArrayAdapter<String>adapter;
    User3 userrr;
    String kname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_myorder);

        final TextView k = (TextView) findViewById(R.id.k);
        k.setEnabled(false);
        Intent i = getIntent();

        String tvv1 = i.getStringExtra(LoginPage.Extra_String15);
        k.setText(tvv1);
        kname=k.getText().toString();


        userrr=new User3();
        listView=(ListView)findViewById(R.id.listView);
        db = FirebaseDatabase.getInstance();
        users2 = db.getReference("Users");
        list = new ArrayList<>();
//        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);

        users2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // User3 user=dataSnapshot.getValue(User3.class);
                //DataSnapshot dss= dataSnapshot.child("username_reg").child("Myorder");
                //Iterable<DataSnapshot> dataSnapshotIterable= dss.getChildren();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    userrr = ds.getValue(User3.class);
                    //User3 c=ds.getValue(User3.class);
                    list.add("Firstname: "+userrr.getFirstName() + "\n" + "Lastname: "+userrr.getLastName() + "\n" + "EmailID: "+userrr.getEmailID() + "\n" + "Mobile Number: "+userrr.getMobile() + "\n" + "Address: "+userrr.getAddress());


                    //Toast.makeText(MyOrder.this,"data updated",Toast.LENGTH_SHORT).show();

                }
                listView.setAdapter(adapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
