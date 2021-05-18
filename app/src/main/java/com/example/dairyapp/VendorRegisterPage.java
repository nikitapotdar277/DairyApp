package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class VendorRegisterPage extends AppCompatActivity{

    private EditText VendorFirstName;
    private EditText VendorLastName;
    private EditText VendorMobile;
    private EditText VendorEmailID;
    private EditText VendorUsername_reg;
    private EditText VendorPassword_reg;
    private EditText VendorDairyName;
    private EditText VendorDairyAddress;
    String vfname,vlname,vmob,vpass,vemail,vusern,vadd,vdname;
    private Button VendorRegister_reg,Refresh;
    int x=0;

    FirebaseDatabase db;
    DatabaseReference Vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_register_vendor);
        db = FirebaseDatabase.getInstance();
            Vendor = db.getReference("Vendor");


        VendorFirstName = (EditText) findViewById(R.id.et_Vendor_FirstName);
        VendorLastName = (EditText) findViewById(R.id.et_Vendor_LastName);
        VendorMobile = (EditText) findViewById(R.id.et_Vendor_Mobile);
        VendorEmailID = (EditText) findViewById(R.id.et_Vendor_Email);
        VendorDairyName = (EditText) findViewById(R.id.et_dairyname);
        VendorDairyAddress = (EditText) findViewById(R.id.et_dairyaddress);
        VendorUsername_reg = (EditText) findViewById(R.id.et_Vendor_Username_Register);
        VendorPassword_reg = (EditText) findViewById(R.id.etp_Vendor_Password_Register);
        VendorRegister_reg = (Button) findViewById(R.id.btn_Vendor_Register_Page);
        Refresh = (Button)findViewById(R.id.ref_btn);

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        VendorRegister_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerVendor();
            }
        });
    }
    public void registerVendor(){
        initialize();

        String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,128}" +

                "\\@" +

                "[a-zA-Z][a-zA-Z]{0,64}" +

                "(" +

                "\\." +

                "[a-zA-Z][a-zA-Z]{0,25}" +

                ")+";

        String validfname = "[a-zA-Z][a-zA-Z]{0,25}" ;
        String validlname = "[a-zA-Z][a-zA-Z]{0,25}" ;
        String validnum = "[0-9]{10}" ;
        String validuser = "[a-zA-Z0-9\\+\\.\\_\\%\\@\\-\\+]{1,64}";
        String validpass = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{6,16}";

        String vfname = VendorFirstName.getText().toString();
        String vlname = VendorLastName.getText().toString();
        String vemail = VendorEmailID.getText().toString();
        String num = VendorMobile.getText().toString();
        String vendor1 = VendorUsername_reg.getText().toString();
        String vpass = VendorPassword_reg.getText().toString();


        Matcher matcher = Pattern.compile(validemail).matcher(vemail);

        Matcher matcherf = Pattern.compile(validfname).matcher(vfname);

        Matcher matcherl = Pattern.compile(validlname).matcher(vlname);

        Matcher matchernum = Pattern.compile(validnum).matcher(num);

        Matcher matcheruser = Pattern.compile(validuser).matcher(vendor1);

        Matcher matcherpass = Pattern.compile(validpass).matcher(vpass);


        if (matcherf.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorFirstName.setError("Enter Valid First Name");
            //Toast.makeText(getApplicationContext(),"Enter Valid Firstname",Toast.LENGTH_LONG).show();
        }

        if (matcherl.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorLastName.setError("Enter Valid Last Name");
            //Toast.makeText(getApplicationContext(),"Enter Valid Lastname",Toast.LENGTH_LONG).show();
        }

        if (matchernum.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorMobile.setError("Enter Valid Mobile Number");
            //Toast.makeText(getApplicationContext(),"Enter Valid Firstname",Toast.LENGTH_LONG).show();
        }

        if (matcher.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorEmailID.setError("Enter Valid Email-Id");

            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }

        if (vdname.isEmpty())
         {
           VendorDairyName.setError("Enter Valid Name of your Dairy");
        }
        else
        {
          x++;
        }


        if(vadd.isEmpty())
        {
            VendorDairyAddress.setError("Enter Valid Address of your Dairy");
        }
        else
        {
            x++;
        }

        if (matcheruser.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorUsername_reg.setError("Enter Valid Username");
            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }


        if (matcherpass.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            VendorPassword_reg.setError("Enter Valid Password");

            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }

        //Password_reg.setError("Enter Password");




        final Vendor vendor = new Vendor(
                VendorFirstName.getText().toString(),
                VendorLastName.getText().toString(),
                VendorMobile.getText().toString(),
                VendorEmailID.getText().toString(),
                VendorDairyName.getText().toString(),
                VendorDairyAddress.getText().toString(),

                VendorUsername_reg.getText().toString(),
                VendorPassword_reg.getText().toString()
        );

            /*users.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(user.getUsername_reg()).exists()){
                        Toast.makeText(RegisterPage.this,"Already Exists",Toast.LENGTH_SHORT).show();
                    }
                    else if(x>=7)
                    {
                        users.child(user.getUsername_reg()).setValue(user);
                        Toast.makeText(RegisterPage.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(this, LoginPage.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/

        /* Original*/
        Vendor.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(vendor.getVendorUsername_reg()).exists()){
                    Toast.makeText(VendorRegisterPage.this,"Username already exists",Toast.LENGTH_SHORT).show();
                }
                else if(x==8)
                {
                    Vendor.child(vendor.getVendorUsername_reg()).setValue(vendor);
                    Toast.makeText(VendorRegisterPage.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(this, LoginPage.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(x==8) {
            startActivity(new Intent(this, LoginPage.class));

        }
        //startActivity(new Intent(this, LoginPage.class));
    }

    public boolean valid(){
        boolean v = true;
        if(vfname.isEmpty()){
            VendorFirstName.setError("Please Enter Valid Name");
            v = false;
        }

        if(vlname.isEmpty()){
            VendorLastName.setError("Please Enter Valid Name");
            v = false;
        }

        if(vmob.isEmpty()){
            VendorMobile.setError("Please Enter Valid Name");
            v = false;
        }

        if(vemail.isEmpty()){
            VendorEmailID.setError("Please Enter Valid Name");
            v = false;
        }
        if (vdname.isEmpty()) {
            VendorDairyName.setError("Please Enter Valid Dairy Name ");
        }

        if(vadd.isEmpty()){
            VendorDairyAddress.setError("Please Enter Valid Dairy Address");
            v = false;
        }
        if(vusern.isEmpty()){
            VendorDairyAddress.setError("Please Enter Valid Data");
            v = false;
        }
        if(vpass.isEmpty()){
            VendorDairyAddress.setError("Please Enter Valid Data");
            v = false;
        }
        return v;
    }

    public void initialize(){
        vfname = VendorFirstName.getText().toString().trim();
        vlname = VendorLastName.getText().toString().trim();
        vmob = VendorMobile.getText().toString().trim();
        vemail = VendorEmailID.getText().toString().trim();
        vdname = VendorDairyName.getText().toString().trim();
        vadd = VendorDairyAddress.getText().toString().trim();
        vusern = VendorUsername_reg.getText().toString().trim();
        vpass = VendorPassword_reg.getText().toString().trim();
    }


}
