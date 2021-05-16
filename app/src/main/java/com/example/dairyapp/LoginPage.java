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

public class LoginPage extends AppCompatActivity {
    public static final String Extra_String15 = "com.example.dark_1.Extra_String15";
    public static final String Extra_String12 = "com.example.dark_1.Extra_String12";
    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Register;
    FirebaseDatabase db;
    DatabaseReference users1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_login);

        Username = findViewById(R.id.etUsername);

        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.btn_Reg);

        db = FirebaseDatabase.getInstance();
        users1 = db.getReference("Users");

        Login.setOnClickListener(view -> validate(Username.getText().toString(), Password.getText().toString(),Username.getText().toString()));

        Register.setOnClickListener(view -> registerPage());
    }

    private void validate(final String userName, final String passWord, final String s1) {
        users1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(userName).exists()) {

                    if (!userName.isEmpty()) {
                        User login = dataSnapshot.child(userName).getValue(User.class);

                        assert login != null;
                        if (login.getPassword_reg().equals(passWord)) {
                            Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(LoginPage.this, MainActivity.class);
                            //Intent i1= new Intent(LoginPage.this, place_order.class);
                            main.putExtra(Extra_String15,s1);
                            main.putExtra(Extra_String12,s1);
                            startActivity(main);

                        }
                        else {
                            Toast.makeText(LoginPage.this, "Password is Wrong", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginPage.this, "Username not registered", Toast.LENGTH_SHORT).show();
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
        startActivity(new Intent(this, RegisterPage.class));
    }


}
