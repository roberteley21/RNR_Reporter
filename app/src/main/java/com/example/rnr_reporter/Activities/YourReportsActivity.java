package com.example.rnr_reporter.Activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.List;

public class YourReportsActivity extends AppCompatActivity {
    private rnrViewModel mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_reports);

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
