package com.elouazzani.myapplicationtest;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define the Bottom Navigation View
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        final FragmentManager fragmentManager=getSupportFragmentManager();
        // define the fragments
        final Fragment trendingFragment=new TrendingFragment();
        final Fragment settingFragment=new SettingFragment();

        // handle the navigation selection
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.trending:
                        fragment=trendingFragment;
                        break;
                    case R.id.setting:
                        fragment=settingFragment;
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.nav_fragment, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.trending);

    }


}