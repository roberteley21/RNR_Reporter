package com.example.rnr_reporter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.Entities.Property;
import com.example.rnr_reporter.DataBase.Entities.Situation;
import com.example.rnr_reporter.R;
import com.example.rnr_reporter.RecyclerView.AdapterList;
import com.example.rnr_reporter.rnrViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class YourReportsActivity extends AppCompatActivity {
    private rnrViewModel mView;
    DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_reports);

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
                        Intent main =new Intent(YourReportsActivity.this, MainActivity.class);
                        startActivity(main);
                        break;
                    case R.id.your_reports:
                        Intent your_reports = new Intent(YourReportsActivity.this, YourReportsActivity.class);
                        startActivity(your_reports);
                        break;
                    default:
                        break;
                }
                dLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AdapterList adapter = new AdapterList(this);
        recyclerView.setAdapter(adapter);


        mView = new ViewModelProvider(this).get(rnrViewModel.class);
        mView.getAllInjuries().observe(this, new Observer<List<Injury>>() {
            @Override
            public void onChanged(@Nullable List<Injury> p_injuries) {
                adapter.setInjuryForms(p_injuries);
            }
        });
      mView.getAllProperties().observe(this, new Observer<List<Property>>() {
            @Override
            public void onChanged(@Nullable List<Property> p_properties) {
                adapter.setPropertyForms(p_properties);
            }
        });
        mView.getAllSituations().observe(this, new Observer<List<Situation>>() {
            @Override
            public void onChanged(@Nullable List<Situation> p_situations) {
                adapter.setSituationForms(p_situations);
            }
        });
    }
}
