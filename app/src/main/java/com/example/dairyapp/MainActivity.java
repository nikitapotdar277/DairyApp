package com.example.dairyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.security.PrivateKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView milk, Paneer, Curd, eggs,Butter,Myorder,Exit;
    TextView tv;

    public static final String Extra_String = "com.example.dark_1.Extra_String";
    public static final String Extra_String1 = "com.example.dark_1.Extra_String1";
    public static final String Extra_username = "com.example.dark_1.Extra_String2";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Intent main = getIntent();
        String usnm = main.getStringExtra(LoginPage.Extra_String15);
        System.out.println(usnm);

        Header header = (Header) findViewById(R.id.header);
        header.initHeader();
        header.findViewById(R.id.cart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Cart1.class);
                i.putExtra(place_order.Extra_username, usnm);
                view.getContext().startActivity(i);
            }
        });
        header.findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserProfile.class);
                intent.putExtra(Extra_username, usnm);
                view.getContext().startActivity(intent);
            }
        });

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //tv = (TextView)findViewById(R.id.tv);
        milk = (CardView) findViewById(R.id.card_01);
        Paneer = (CardView) findViewById(R.id.card_02);
        Curd = (CardView) findViewById(R.id.card_03);
        eggs = (CardView) findViewById(R.id.card_04);
        Myorder = (CardView) findViewById(R.id.card_05);
//        Butter = (CardView) findViewById(R.id.card_06);
        Exit = (CardView) findViewById(R.id.card_07);
        milk.setOnClickListener(this);
        Paneer.setOnClickListener(this);
        Curd.setOnClickListener(this);
        eggs.setOnClickListener(this);
//        Butter.setOnClickListener(this);
        Myorder.setOnClickListener(this);
        Exit.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent i;
        Intent main= getIntent();

        switch (view.getId()) {
            case R.id.card_01:
                i = new Intent(this, CowMilk.class);
                String usercarrier0=main.getStringExtra(LoginPage.Extra_String15);;
                i.putExtra(LoginPage.Extra_String15,usercarrier0);
                startActivity(i);
                break;
            case R.id.card_02:
                i = new Intent(this, place_order.class);
                i.putExtra(Extra_String,"Paneer");
                i.putExtra(Extra_String1,"260/kg");
                String usercarrier=main.getStringExtra(LoginPage.Extra_String15);;
                i.putExtra(LoginPage.Extra_String15,usercarrier);
                startActivity(i);
                break;
            case R.id.card_03:
                i = new Intent(this, place_order.class);
                i.putExtra(Extra_String,"Curd");
                i.putExtra(Extra_String1,"100/kg");
                String usercarrier1=main.getStringExtra(LoginPage.Extra_String15);;
                i.putExtra(LoginPage.Extra_String15,usercarrier1);
                startActivity(i);
                break;
            case R.id.card_04:
                i = new Intent(this, place_order.class);
                i.putExtra(Extra_String,"Eggs");
                i.putExtra(Extra_String1,"5/egg");
                String usercarrier2=main.getStringExtra(LoginPage.Extra_String15);;
                i.putExtra(LoginPage.Extra_String15,usercarrier2);
                startActivity(i);
                break;
            case R.id.card_05:
                i = new Intent(this, place_order.class);
                i.putExtra(Extra_String,"Butter");
                i.putExtra(Extra_String1,"200/kg");
                String usercarrier3=main.getStringExtra(LoginPage.Extra_String15);;
                i.putExtra(LoginPage.Extra_String15,usercarrier3);
                startActivity(i);
                break;
//            case R.id.card_06:
//                i = new Intent(this, MyOrder.class);
//                String usercarrier6=main.getStringExtra(LoginPage.Extra_String15);;
//                i.putExtra(LoginPage.Extra_String15,usercarrier6);
//                startActivity(i);
//                break;
            case R.id.card_07:
                Intent x = new Intent(this,LoginPage.class);
                startActivity(x);
                finish();
                System.exit(0);
                //i = new Intent(this,place_order.class);startActivity(i);
                break;
            default:
                break;

        }
    }
}
