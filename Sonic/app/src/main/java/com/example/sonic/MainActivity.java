package com.example.sonic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.window.OnBackAnimationCallback;

import com.example.sonic.databinding.ActivityMainBinding;
import com.example.sonic.network.model.UserDTO;
import com.example.sonic.network.remote.APIServiceToken;
import com.example.sonic.network.remote.RetrofitClientToken;
import com.google.android.material.navigation.NavigationView;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String token = DataLocalManager.getInstance().getToken();
        if (token.isEmpty()) {
            Intent mIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(mIntent);
        }

//
        binding.viewPager2.setUserInputEnabled(false);
    //  binding.viewPager2.setPageTransformer(new ZoomOutPageTransformer());
//


//
        DrawerLayout mDrawerLayout = binding.drawerLayout;
        Toolbar mToolbar = binding.toolbar;

        setSupportActionBar(mToolbar);


         toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.open, R.string.close);
//        toggle.setDrawerIndicatorEnabled(false); // Disable default toggle icon
//        toggle.setHomeAsUpIndicator(R.drawable.ic_bars_sort); // Disable Up indicator
//        toggle.setToolbarNavigationClickListener(view -> {
//            // Xử lý sự kiện khi nút tuỳ chỉnh được nhấn
//            if ( binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                binding.drawerLayout.closeDrawer(GravityCompat.START);
//            } else {
//                binding.drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
//
//        mDrawerLayout.addDrawerListener(toggle);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_bars_sort);

        //

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setCustomView(customToggleView);

//
        NavigationView mNavigationView = binding.navView;
        mNavigationView.setNavigationItemSelectedListener(this);
//

//
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this,getSupportActionBar(),toggle);
        binding.viewPager2.setAdapter(myViewPagerAdapter);

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.bottom_home) {
                binding.viewPager2.setCurrentItem(0);
                binding.toolbar.setTitle(R.string.home);
            } else if (id == R.id.bottom_search) {
                binding.viewPager2.setCurrentItem(1);
                binding.toolbar.setTitle(R.string.search);
            } else if (id == R.id.bottom_library) {
                binding.viewPager2.setCurrentItem(2);
                binding.toolbar.setTitle(R.string.lib);
            } else if (id == R.id.bottom_premium) {
                binding.viewPager2.setCurrentItem(3);
                binding.toolbar.setTitle(R.string.premium);
            }
            return true;
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        binding.bottomNavigation.getMenu().findItem(R.id.bottom_home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNavigation.getMenu().findItem(R.id.bottom_search).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNavigation.getMenu().findItem(R.id.bottom_library).setChecked(true);
                        break;
                    case 3:
                        binding.bottomNavigation.getMenu().findItem(R.id.bottom_premium).setChecked(true);
                        break;
                }
            }
        });

        //

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện ở đây
                onBackPressed();
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.bottom_inf_user) {
//            binding.viewPager2.setCurrentItem(4);

            Intent mIntent=new Intent(this,InfUserActivity.class);
            startActivity(mIntent);

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public boolean onSupportNavigateUp() {
        // Điều hướng ngược lại (navigate up) khi bấm nút quay trở lại
        binding.viewPager2.setCurrentItem(0);
        return true;
    }

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Ấn back một lần nữa để thoát", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000); // Thời gian cho phép ấn back lần thứ hai
    }


}

