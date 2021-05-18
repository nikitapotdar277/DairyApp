package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CowMilk extends AppCompatActivity {
    public static final String Extra_String = "com.example.dark_1.Extra_String";
    public static final String Extra_String1 = "com.example.dark_1.Extra_String1";
    public static final String Extra_String2 = "com.example.dark_1.Extra_String2";
    private CardView cow,buffalo;
    TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milk_cow);
        t3 = findViewById(R.id.t3);
        cow= findViewById(R.id.card_cow_01);
        buffalo= findViewById(R.id.card_buf_02);
        Intent main = getIntent();
        String usnm = main.getStringExtra(LoginPage.Extra_String15);

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
            intent.putExtra(MainActivity.Extra_username, usnm);
            view.getContext().startActivity(intent);
        });

        CardView cv1 = findViewById(R.id.card_cow_01);

        cow.setOnClickListener(v -> place_from_cow());

        buffalo.setOnClickListener(v -> place_from_buff());

    }
    private void place_from_cow()
    {

        Intent i = new Intent(this,place_order.class);
        Intent main=getIntent();
        i.putExtra(Extra_String,"Cow Milk");
        i.putExtra(Extra_String1,"45/ltr");
        String usercarrier1=main.getStringExtra(LoginPage.Extra_String15);
        i.putExtra(LoginPage.Extra_String15,usercarrier1);
        startActivity(i);
    }

    private void place_from_buff()
    {
        Intent i = new Intent(this,place_order.class);
        Intent main=getIntent();
        i.putExtra(Extra_String,"Buffalo Milk");
        i.putExtra(Extra_String1,"60/ltr");
        String usercarrier1=main.getStringExtra(LoginPage.Extra_String15);
        i.putExtra(LoginPage.Extra_String15,usercarrier1);
        startActivity(i);


    }
}