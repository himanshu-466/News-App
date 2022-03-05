package com.mohit.newsappapi;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mohit.newsappapi.fragment.Entertainment;
import com.mohit.newsappapi.fragment.Health;
import com.mohit.newsappapi.fragment.Home;
import com.mohit.newsappapi.fragment.Science;
import com.mohit.newsappapi.fragment.Sports;
import com.mohit.newsappapi.fragment.Technology;

import org.jetbrains.annotations.NotNull;

public class pagerAdapter extends FragmentPagerAdapter {
    private int tabcunt ;

    public pagerAdapter(@NonNull @NotNull FragmentManager fm, int behavior,int tabcunt) {
        super(fm, behavior);
        this.tabcunt =tabcunt;
    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Home();
            case 1:
                return new Sports();
            case 2:
                return new Health();
            case 3:
                return new Science();
            case 4:
                return new Entertainment();
            case 5:
                return new Technology();
            default:
                return  new Home();

        }


    }

    @Override
    public int getCount() {
        return tabcunt;
    }
}
