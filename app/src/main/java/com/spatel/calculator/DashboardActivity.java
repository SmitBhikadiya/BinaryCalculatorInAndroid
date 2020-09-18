package com.spatel.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.setTitle("Dashboard");

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);

        drawerLayout = findViewById(R.id.drawer);



        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setCheckedItem(R.id.home);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.calculator:
                        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.conversion:
                        Intent wallet = new Intent(DashboardActivity.this,HomeActivity.class);
                        startActivity(wallet);
                        break;
                    case R.id.profile:
                        Intent profile = new Intent(DashboardActivity.this,Profile.class);
                        startActivity(profile);
                        break;
                    case R.id.share:
                        Toast.makeText(DashboardActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate:
                        Toast.makeText(DashboardActivity.this, "Rate", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.privacy:
                        Toast.makeText(DashboardActivity.this, "Privacy", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.terms:
                        Toast.makeText(DashboardActivity.this, "Terms", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.exit:
                        finish();
                        System.exit(0);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
}