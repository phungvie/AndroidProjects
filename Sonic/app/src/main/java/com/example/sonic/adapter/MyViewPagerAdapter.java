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
import com.example.sonic.fragment.SongFragment;
import com.example.sonic.network.model.SongDTO;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    ActionBarDrawerToggle toggle;
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,ActionBarDrawerToggle toggle) {
        super(fragmentActivity);
        this.toggle=toggle;


    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SongFragment(new SongDTO(9, "bài hát 9", "", "/data/stream/nhac1.mp3", null, ""));
            case 1:
                return new SearchFragment();
            case 2:
                return new LibraryFragment(toggle);
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
