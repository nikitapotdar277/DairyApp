package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BillPage extends AppCompatActivity {
    Button C_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_bill);

        Button C_btn = (Button)findViewById(R.id.C_btn);

        final EditText etxx = (EditText) findViewById(R.id.et_Final_Price);
        etxx.setEnabled(false);
        Intent i = getIntent();

        String tvv1 = i.getStringExtra(place_order.Extra_String3);
        etxx.setText(tvv1);

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
