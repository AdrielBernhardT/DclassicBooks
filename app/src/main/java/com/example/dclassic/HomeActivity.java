package com.example.dclassic;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

import android.os.Handler;
import android.os.Looper;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        pager = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.store1,
                R.drawable.store2,
                R.drawable.store3,
                R.drawable.store4
        );

        StoreAdapter adapter = new StoreAdapter(images);
        pager.setAdapter(adapter);

        ImageButton rightBtn = findViewById(R.id.rightBtn);
        ImageButton leftBtn = findViewById(R.id.leftBtn);

        rightBtn.setOnClickListener(v -> {
            if (pager.getCurrentItem() < images.size()-1) {
                pager.setCurrentItem(
                        pager.getCurrentItem()+1,
                        true
                );
            }
        });

        leftBtn.setOnClickListener(v -> {
            if (pager.getCurrentItem() > 0) {
                pager.setCurrentItem(
                        pager.getCurrentItem()-1,
                        true
                );
            }
        });

        Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int next =
                        (pager.getCurrentItem()+1)%images.size();

                pager.setCurrentItem(next,true);

                handler.postDelayed(this,3000);
            }
        };

        handler.postDelayed(runnable,3000);

        DrawerLayout drawerLayout;
        ImageButton menuBtn;

        drawerLayout = findViewById(R.id.drawerLayout);
        menuBtn = findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.END);
        });
    }
}