package com.example.dairyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context)
    {
        this.context = context;
    };

    public int[] slide_images = {
            R.drawable.milk_2,
            R.drawable.milk_man_delivery,
            R.drawable.dairy_product
    };

    public String[] slide_headings = {
            "Daily Milk Service",
            "Dairy Products",
            "Delivery Service"
    };

    public String[] slide_desc = {
            "Daily Milk Service Daily Milk ServiceDaily Milk ServiceDaily Milk ServiceDaily Milk Service",
            "Dairy Products Daily Milk ServiceDaily Milk ServiceDaily Milk ServiceDaily Milk ServiceDaily Milk Service",
            "Delivery Service Daily Milk ServiceDaily Milk ServiceDaily Milk ServiceDaily Milk ServiceDaily Milk Service"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    };

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==  (RelativeLayout) o;
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideImageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.textheadslider);
        TextView slideDescription = (TextView) view.findViewById(R.id.textDetailslider);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);
        return view;

    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
