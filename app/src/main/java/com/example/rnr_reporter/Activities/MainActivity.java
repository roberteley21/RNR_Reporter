package com.example.rnr_reporter.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.rnr_reporter.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Button injury, property, dangerous;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.main:
                        Intent switchActivityIntent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(switchActivityIntent);
                        break;
                    case R.id.your_reports:
                        Intent switchYourReportIntent = new Intent(MainActivity.this, SummaryActivity.class);
                        startActivity(switchYourReportIntent);
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        injury = findViewById(R.id.injury);
        injury.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switchInjury();
        }

    });
        property = findViewById(R.id.property);
        property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchProperty();
            }
        });
        dangerous = findViewById(R.id.dangerous);
        dangerous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchDangerous();
            }
        });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                Log.d(TAG, "Favourite option clicked");
                return true;
            case R.id.your_reports:
                Log.d(TAG, "Delete option clicked");
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void switchInjury() {
        Intent switchActivityIntent = new Intent(this, InjuryReportActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchProperty() {
        Intent switchActivityIntent = new Intent(this, PropertyDamageActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchDangerous() {
        Intent switchActivityIntent = new Intent(this, DangerousSituationActivity.class);
        startActivity(switchActivityIntent);
    }
}