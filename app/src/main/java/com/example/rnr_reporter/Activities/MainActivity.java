package com.example.rnr_reporter.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.rnr_reporter.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Button injury, property, dangerous;
    DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dLayout.openDrawer(Gravity.LEFT);
            }
        });
        setNavigationDrawer();
    }
    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.bringToFront();
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.main:
                        Intent main =new Intent(MainActivity.this, MainActivity.class);
                        startActivity(main);
                        break;
                    case R.id.your_reports:
                        Intent your_reports = new Intent(MainActivity.this, YourReportsActivity.class);
                        startActivity(your_reports);
                        break;
                    default:
                        break;
                }
                dLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });

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
    private void switchInjury() {
        Intent switchActivityIntent = new Intent(this, InjuryReportActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchProperty() {
        Intent switchActivityIntent = new Intent(this, YourReportsActivity.class);//PropertyDamageActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchDangerous() {
        Intent switchActivityIntent = new Intent(this, DangerousSituationActivity.class);
        startActivity(switchActivityIntent);
    }
}