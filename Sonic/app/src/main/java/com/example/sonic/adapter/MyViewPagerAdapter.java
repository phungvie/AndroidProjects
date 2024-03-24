package com.example.sonic.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sonic.fragment.HomeFragment;
import com.example.sonic.fragment.LibraryFragment;
import com.example.sonic.fragment.PremiumFragment;
import com.example.sonic.fragment.SearchFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    ActionBar mActionBar;

    ActionBarDrawerToggle toggle;
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,ActionBar mActionBar,ActionBarDrawerToggle toggle) {
        super(fragmentActivity);
        this.mActionBar=mActionBar;
        this.toggle=toggle;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new LibraryFragment(mActionBar,toggle);
            case 3:
                return new PremiumFragment();
            default:
                return new HomeFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
