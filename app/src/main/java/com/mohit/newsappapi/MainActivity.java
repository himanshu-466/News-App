package com.mohit.newsappapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    Toolbar toolbar;
    TabItem home,sports,health,entertainment,science,technology;
    String api ="cec7d4b0ca8c4f12861db30bde214869";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);
        pagerAdapter viewpagerAdapter = new pagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
        pager.setAdapter(viewpagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    public void init()
    {
        tabLayout = findViewById(R.id.include);
        home =findViewById(R.id.homey);
        sports =findViewById(R.id.sports);
        health =findViewById(R.id.health);
        science =findViewById(R.id.science);
        technology =findViewById(R.id.technology);
        entertainment =findViewById(R.id.entertainment);
        pager =findViewById(R.id.viewpager);
        toolbar =findViewById(R.id.toolbar);


    }
}