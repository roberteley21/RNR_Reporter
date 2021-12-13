package com.example.rnr_reporter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rnr_reporter.DataBase.Entities.Injury;
import com.example.rnr_reporter.DataBase.Entities.Property;
import com.example.rnr_reporter.DataBase.Entities.Situation;
import com.example.rnr_reporter.R;
import com.example.rnr_reporter.FormType;
import com.example.rnr_reporter.rnrViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

public class SummaryActivity extends AppCompatActivity {

    Button submit;
    TextView name, type, description, location, reporter, time, date;

    private rnrViewModel mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        mView = new ViewModelProvider(this).get(rnrViewModel.class);

        Toolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow);
        getSupportActionBar().setTitle("Summary");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        description = findViewById(R.id.description);
        location =  findViewById(R.id.location);
        reporter = findViewById(R.id.reporter);
        time = findViewById(R.id.time);
        date = findViewById(R.id.date);

        Intent intent = getIntent();
        String n = intent.getStringExtra("name");
        String t = intent.getStringExtra("type");
        String d = intent.getStringExtra("description");
        String l = intent.getStringExtra("location");
        String r = intent.getStringExtra("reporter");
        String tm = intent.getStringExtra("time");
        String dt = intent.getStringExtra("date");
        FormType form = (FormType) intent.getSerializableExtra("form");
        name.setText(n);
        type.setText(t);
        description.setText(d);
        location.setText(l);
        reporter.setText(r);
        time.setText(tm);
        date.setText(dt);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(form) {
                    case INJURY:
                        mView.insertInjury(new Injury(n, t, d, tm, dt, l, r));
                        break;
                    case DAMAGE:
                        mView.insertProperty(new Property(n, t, d, tm, dt, l, r));
                        break;
                    case SITUATION:
                        mView.insertSituation(new Situation(t, d, tm, dt, l, r));
                        break;
                }
                switchSubmit();
            }
        });
    }

    private void switchSubmit() {
        Intent switchActivityIntent = new Intent(this, SubmissionActivity.class);
        startActivity(switchActivityIntent);
    }
}
