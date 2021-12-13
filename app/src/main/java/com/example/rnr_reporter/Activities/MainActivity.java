package com.example.rnr_reporter.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rnr_reporter.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Button injury, property, dangerous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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