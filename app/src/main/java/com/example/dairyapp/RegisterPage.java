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

public class RegisterPage extends AppCompatActivity{

    private EditText FirstName;
    private EditText LastName;
    private EditText Mobile;
    private EditText EmailID;
    private EditText Address;
    private EditText Username_reg;
    private EditText Password_reg;
    String fname,lname,mob,pass,email,usern,add;
    private Button Register_reg,Refresh;
    int x=0;

    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_register);
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");


        FirstName = (EditText) findViewById(R.id.et_FirstName);
        LastName = (EditText) findViewById(R.id.et_LastName);
        Mobile = (EditText) findViewById(R.id.et_Mobile);
        EmailID = (EditText) findViewById(R.id.et_Email);
        Address = (EditText) findViewById(R.id.et_address);
        Username_reg = (EditText) findViewById(R.id.et_Username_Register);
        Password_reg = (EditText) findViewById(R.id.etp_Password_Register);
        Register_reg = (Button) findViewById(R.id.btn_Register_Page);
        Refresh = (Button)findViewById(R.id.ref_btn);

        Refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        Register_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    public void register(){
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

        String fname = FirstName.getText().toString();
        String lname = LastName.getText().toString();
        String email = EmailID.getText().toString();
        String num = Mobile.getText().toString();
        String user1 = Username_reg.getText().toString();
        String pass = Password_reg.getText().toString();


        Matcher matcher = Pattern.compile(validemail).matcher(email);

        Matcher matcherf = Pattern.compile(validfname).matcher(fname);

        Matcher matcherl = Pattern.compile(validlname).matcher(lname);

        Matcher matchernum = Pattern.compile(validnum).matcher(num);

        Matcher matcheruser = Pattern.compile(validuser).matcher(user1);

        Matcher matcherpass = Pattern.compile(validpass).matcher(pass);


        if (matcherf.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            FirstName.setError("Enter Valid First Name");
            //Toast.makeText(getApplicationContext(),"Enter Valid Firstname",Toast.LENGTH_LONG).show();
        }

        if (matcherl.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            LastName.setError("Enter Valid Last Name");
            //Toast.makeText(getApplicationContext(),"Enter Valid Lastname",Toast.LENGTH_LONG).show();
        }

        if (matchernum.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            Mobile.setError("Enter Valid Mobile Number");
            //Toast.makeText(getApplicationContext(),"Enter Valid Firstname",Toast.LENGTH_LONG).show();
        }

        if (matcher.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            EmailID.setError("Enter Valid Email-Id");

            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }


        if(add.isEmpty())
        {
            Address.setError("Enter Valid Address");
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
            Username_reg.setError("Enter Valid Username");
            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }


        if (matcherpass.matches()){
            //Toast.makeText(getApplicationContext(),"True",Toast.LENGTH_SHORT).show();
            x++;

        }
        else {
            Password_reg.setError("Enter Valid Password");

            //Toast.makeText(getApplicationContext(),"Enter Valid Email-Id",Toast.LENGTH_LONG).show();
        }

        //Password_reg.setError("Enter Password");




        final User user = new User(
                FirstName.getText().toString(),
                LastName.getText().toString(),
                Mobile.getText().toString(),
                EmailID.getText().toString(),
                Address.getText().toString(),

                Username_reg.getText().toString(),
                Password_reg.getText().toString()
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
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(user.getUsername_reg()).exists()){
                    Toast.makeText(RegisterPage.this,"Username already exists",Toast.LENGTH_SHORT).show();
                }
                else if(x==7)
                {
                    users.child(user.getUsername_reg()).setValue(user);
                    Toast.makeText(RegisterPage.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(this, LoginPage.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(x==7)
        {
            startActivity(new Intent(this, LoginPage.class));
        }

        //startActivity(new Intent(this, LoginPage.class));
    }

    public boolean valid(){
        boolean v = true;
        if(fname.isEmpty()){
            FirstName.setError("Please Enter Valid Name");
            v = false;
        }

        if(lname.isEmpty()){
            LastName.setError("Please Enter Valid Name");
            v = false;
        }

        if(mob.isEmpty()){
            Mobile.setError("Please Enter Valid Name");
            v = false;
        }

        if(email.isEmpty()){
            EmailID.setError("Please Enter Valid Name");
            v = false;
        }

        if(add.isEmpty()){
            Address.setError("Please Enter Valid Name");
            v = false;
        }
        return v;
    }

    public void initialize(){
        fname = FirstName.getText().toString().trim();
        lname = LastName.getText().toString().trim();
        mob = Mobile.getText().toString().trim();
        email = EmailID.getText().toString().trim();
        add = Address.getText().toString().trim();
        usern = Username_reg.getText().toString().trim();
        pass = Password_reg.getText().toString().trim();
    }


}
