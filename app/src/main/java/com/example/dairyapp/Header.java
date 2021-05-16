package com.example.dairyapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Header extends RelativeLayout {
    private TextView label;
    private ImageButton profileButton;

    public Header(Context context) {
        super(context);
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Header(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initHeader() {
        inflateHeader();
    }

    private void inflateHeader() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.header, this);
        TextView logo = (TextView) findViewById(R.id.logoText);
        ImageButton profile = (ImageButton) findViewById(R.id.profile);

    }

//    findViewById(R.id.logoText).setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Log.d(TAG,"Clicked");
//        }
//    });
}

