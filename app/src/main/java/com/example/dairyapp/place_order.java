package com.example.dairyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

public class place_order extends AppCompatActivity {
    private Button Place_order;
    public String uname,item1,date,total1,qt;
    double quantity,result;
    EditText etx;
    Button total;
    FirebaseDatabase db;
    DatabaseReference users;
    public static final String Extra_String3 = "com.example.dark_1.Extra_String3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_place);
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        Intent man = getIntent();
        String usnm = man.getStringExtra(LoginPage.Extra_String15);

        Header header = findViewById(R.id.header);
        header.initHeader();
        header.findViewById(R.id.profile).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), UserProfile.class);
            intent.putExtra(MainActivity.Extra_username, usnm);
            view.getContext().startActivity(intent);
        });

        final Button total= findViewById(R.id.total);

        final TextView t6 = findViewById(R.id.t6);

        final TextView t2 = findViewById(R.id.t2);

        Intent i = getIntent();
        Intent main =getIntent();

        String tv1 = i.getStringExtra(CowMilk.Extra_String);
        final TextView tv = findViewById(R.id.t4);
        tv.setText(tv1);

        String tv2 = i.getStringExtra(MainActivity.Extra_String1);
        final TextView tvv = findViewById(R.id.t5);
        tvv.setText(tv2);

        String tv3 = main.getStringExtra(LoginPage.Extra_String15);
        final TextView tvvv = findViewById(R.id.t3);
        tvvv.setText(tv3);
        final EditText etx = findViewById(R.id.et1);

        String date=t2.getText().toString();//date
        String uname=tvvv.getText().toString();//username
        String item1=tv.getText().toString();//item
        String qt=etx.getText().toString();//quantity
        final String total1=t6.getText().toString();//total

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        t2.setText(currentDateTimeString);

        total.setOnClickListener(v -> {

            String x;

            String num = etx.getText().toString();
            double quantity=0;

            if(!num.isEmpty()) {
                quantity = Double.parseDouble(num);
            }
            else {
                etx.setError("Enter Quantity");

            }
            String item = tv.getText().toString();

            //if(!num.isEmpty()) {      //etx.setError("Enter Quantity");
            if ((quantity % (0.125)) == 0.00 && quantity!=0) {
                if (item.equals("Cow Milk")) {
                    result = quantity * 45;
                    t6.setText(Double.toString(result));
                } else if (item.equals("Buffalo Milk")) {
                    result = quantity * 60;
                    t6.setText(Double.toString(result));
                } else if (item.equals("Paneer")) {
                    result = quantity * 260;
                    t6.setText(Double.toString(result));
                } else if (item.equals("Curd")) {
                    result = quantity * 100;
                    t6.setText(Double.toString(result));
                } else if (item.equals("Eggs")) {
                    if (quantity % 1 == 0 && quantity >= 6) {
                        result = quantity * 5;
                        t6.setText(Double.toString(result));
                    } else {
                        etx.setError("Enter Valid Quantity and Greater than 6");
                    }
                } else if (item.equals("Butter")) {
                    result = quantity * 200;
                    t6.setText(Double.toString(result));
                }
            }

            else {
                //Toast.makeText(this, "Enter VAlid Quantity", Toast.LENGTH_SHORT).show();
                etx.setError("Enter Valid Quantity");
            }
        });


        final String tot = t6.getText().toString();
        Place_order= findViewById(R.id.b1);
        //tv = (TextView)findViewById(R.id.tv);
        Place_order.setOnClickListener(v -> {
            final User2 userr=new User2(tvvv.getText().toString(),
                    tv.getText().toString(),t2.getText().toString(),
                    t6.getText().toString(),etx.getText().toString());
            users.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(userr.getUname()).exists()){
                        users.child(userr.getUname()).child("Myorder").child(userr.getDate()).setValue(userr);
                        Toast.makeText(place_order.this,"data updated",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            String quantity = etx.getText().toString();
            //String x  = Double.valueOf(quantity);

            if(!quantity.isEmpty())
            {
                bill_Page(t6.getText().toString());
            }
            else
            {
                finish();
                startActivity(getIntent());

            }


        });
    }
    private void bill_Page(String s)
    {
        Intent i;

        Toast.makeText(this, "Order Confirmed", Toast.LENGTH_SHORT).show();
        i = new Intent(this,BillPage.class);
        i.putExtra(Extra_String3,s);
        startActivity(i);

    }
    /*public void initialize2()
    {
        t2.getText().toString().trim();//date
        tvvv.getText().toString();//username
        tv.getText().toString();//item
        etx.getText().toString();//quantity
        t6.getText().toString();//total
    }*/
}
