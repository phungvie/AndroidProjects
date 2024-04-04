package com.example.sonic.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sonic.fragment.HomeFragment;
import com.example.sonic.fragment.LibraryFragment;
import com.example.sonic.fragment.PremiumFragment;
import com.example.sonic.fragment.SearchFragment;
import com.example.sonic.myInterface.IToggle;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    private IToggle mIToggle;
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity,IToggle iToggle) {
        super(fragmentActivity);
        this.mIToggle=iToggle;


    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
//                return new SongFragment(new SongDTO(9, "bài hát 9", "", "/data/stream/HayTraoChoAnh-SonTungMTPSnoopDogg-6010660.mp3", null, ""));\
                return new HomeFragment(mIToggle);
            case 1:
                return new SearchFragment();
            case 2:
                return new LibraryFragment(mIToggle);
            case 3:
                return new PremiumFragment();
            default:
                return new HomeFragment(mIToggle);


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
