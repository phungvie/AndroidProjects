package com.example.lap2_end;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lap2_end.model.Contact;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    public static ArrayList<Contact> data;
    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    NavigationView mNavigationView;
    ViewPager2 mViewPager2;
    BottomNavigationView mBottomNavigationView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.toolbar);
        mNavigationView = findViewById(R.id.nav_view);
        mViewPager2 = findViewById(R.id.view_pager_2);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        //
        data = new ArrayList<>();
        data.add(new Contact(1, "viet", "0987635432", true, Contact.imgViet));
        data.add(new Contact(2, "cuong", "0928765432", false, Contact.imgViet));
        data.add(new Contact(3, "luyen", "0948755432", true, Contact.imgViet));
        data.add(new Contact(4, "minh", "0934555432", false, Contact.imgViet));
        //
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        //
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager2.setAdapter(myViewPagerAdapter);
//        mViewPager2.setUserInputEnabled(true);

        mBottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                getSupportFragmentManager().popBackStack();
                mViewPager2.setCurrentItem(0);
            } else if (id == R.id.bottom_search) {
                getSupportFragmentManager().popBackStack();
                mViewPager2.setCurrentItem(1);
            }
            return true;
        });

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
//                        mToolbar.setTitle(R.string.close);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_search).setChecked(true);
                        break;

                }
            }
        });

        //


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.bottom_home) {
            getSupportFragmentManager().popBackStack();
            mViewPager2.setCurrentItem(0);
        } else if (id == R.id.bottom_search) {
            getSupportFragmentManager().popBackStack();
            mViewPager2.setCurrentItem(1);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}