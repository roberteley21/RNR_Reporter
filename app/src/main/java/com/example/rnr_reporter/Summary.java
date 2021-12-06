package com.example.rnr_reporter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Summary extends AppCompatActivity {

    Button submit;
    TextView name, type, description, location, reporter, time, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

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
                switchSubmit();
            }
        });
    }

    private void switchSubmit() {
        Intent switchActivityIntent = new Intent(this, Submission.class);
        startActivity(switchActivityIntent);
    }
}
