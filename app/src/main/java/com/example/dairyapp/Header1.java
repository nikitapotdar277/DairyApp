package com.example.dairyapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class Header1 extends RelativeLayout{

    public Header1(Context context) {
        super(context);
    }

    public Header1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Header1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initHeader1() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.header1, this);
    }


}
