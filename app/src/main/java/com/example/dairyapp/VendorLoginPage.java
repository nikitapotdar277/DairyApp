package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;
import com.google.firebase.database.ChildEventListener;

public class VendorLoginPage extends AppCompatActivity {
    public static final String Extra_String15 = "com.example.dark_1.Extra_String15";
    public static final String Extra_String12 = "com.example.dark_1.Extra_String12";
    private EditText VendorUsername;
    private EditText VendorPassword;
    private Button Login;
    private Button Register;
    FirebaseDatabase db;
    DatabaseReference vendor1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_login_vendor);

        VendorUsername = (EditText) findViewById(R.id.et_Vendor_Username);

        VendorPassword = (EditText) findViewById(R.id.et_Vendor_Password);
        Login = (Button) findViewById(R.id.btnVendorLogin);
        Register = (Button) findViewById(R.id.btn_Vendor_Register_Page);

        db = FirebaseDatabase.getInstance();
        vendor1 = db.getReference("Vendor");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(VendorUsername.getText().toString(), VendorPassword.getText().toString(),VendorUsername.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPage();
            }
        });
    }

    private void validate(final String userName, final String passWord, final String s1) {
        /* if ((userName.equals("Admin"))&&(userPassword.equals("abcd")))
         {
             Intent main=new Intent(LoginPage.this,AdminActivity.class);
             startActivity(main);
         }*/
        // signIn(Username.getText().toString(),Password.getText().toString());
        vendor1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(userName).exists()) {

                    if (!userName.isEmpty()) {
                        Vendor login = dataSnapshot.child(userName).getValue(Vendor.class);

                        if (login.getPassword_reg().equals(passWord)) {
                            Toast.makeText(VendorLoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(VendorLoginPage.this, MainActivity.class);
                            //Intent i1= new Intent(LoginPage.this, place_order.class);
                            main.putExtra(Extra_String15,s1);
//                            main.putExtra(Extra_String12,s1);
                            startActivity(main);

                        }
                        else {
                            Toast.makeText(VendorLoginPage.this, "Password is Wrong", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(VendorLoginPage.this, "Username not registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void registerPage() {
        //Intent cat= new Intent(LoginPage.this, RegisterPage.class);
        startActivity(new Intent(this, VendorRegisterPage.class));
    }


}
