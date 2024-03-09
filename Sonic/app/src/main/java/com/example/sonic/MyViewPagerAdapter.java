package com.example.sonic;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sonic.fragment.HomeFragment;
import com.example.sonic.fragment.InfUserFragment;
import com.example.sonic.fragment.LibraryFragment;
import com.example.sonic.fragment.PremiumFragment;
import com.example.sonic.fragment.SearchFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
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
                return new LibraryFragment();
            case 3:
                return new PremiumFragment();
            case 4:
                return new InfUserFragment();
            default:
                return new HomeFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
