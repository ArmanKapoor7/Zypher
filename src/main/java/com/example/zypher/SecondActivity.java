package com.example.zypher;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.pager);

        setSupportActionBar(toolbar);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        ImageButton ig = findViewById(R.id.imageButton13);
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotofirst = new Intent();
                gotofirst.setClass(SecondActivity.this,MainActivity.class);
                startActivity(gotofirst);
                finish();
                overridePendingTransition(R.anim.slideinright,R.anim.slideinright);
            }
        });

        ImageButton ig2 = findViewById(R.id.imageButton14);
        ig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotofirst = new Intent();
                gotofirst.setClass(SecondActivity.this,MainActivity.class);
                startActivity(gotofirst);
                finish();
                overridePendingTransition(R.anim.slideinright,R.anim.slideinright);
            }
        });



}


    private void  setupViewPager(ViewPager viewPager) {
        com.example.zypher.PagerAdapter pagerAdapter = new com.example.zypher.PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new Contents(),"Contents");
        pagerAdapter.addFragment(new Bookmarks(),"Bookmarks");
        pagerAdapter.addFragment(new Notes(),"Notes");
        viewPager.setAdapter(pagerAdapter);


    }
}
