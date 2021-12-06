package com.example.rnr_reporter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.rnr_reporter.Activities.SummaryActivity;
import com.example.rnr_reporter.DatePicker;
import com.example.rnr_reporter.R;
import com.example.rnr_reporter.TimePicker;
import com.example.rnr_reporter.formType;

public class InjuryReportActivity extends AppCompatActivity {

    Button submit, time, date;
    EditText name, type, description, location, reporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injury_report);

        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        description = findViewById(R.id.description);
        location =  findViewById(R.id.location);
        reporter = findViewById(R.id.reporter);
        time = findViewById(R.id.time);
        date = findViewById(R.id.date);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchSubmit();
            }
        });
    }

    private void switchSubmit() {
        String n, t, d, l, r, tm, dt;
        n = name.getText().toString();
        t = type.getText().toString();
        d = description.getText().toString();
        l = location.getText().toString();
        r = reporter.getText().toString();
        tm = time.getText().toString();
        dt = date.getText().toString();
        formType form = formType.INJURY;
        if (TextUtils.isEmpty(name.getText())){
            name.setError("Name is required");
        }
        else if (TextUtils.isEmpty(type.getText())){
            type.setError("Type is required");
        }
        else if (TextUtils.isEmpty(description.getText())){
            description.setError("Description is required");
        }
        else if (TextUtils.isEmpty(location.getText())){
            location.setError("Location is required");
        }
        else if (TextUtils.isEmpty(reporter.getText())){
            reporter.setError("Reporter is required");
        }
        else {
            Intent switchActivityIntent = new Intent(this, SummaryActivity.class);
            switchActivityIntent.putExtra("name", n);
            switchActivityIntent.putExtra("type", t);
            switchActivityIntent.putExtra("description", d);
            switchActivityIntent.putExtra("location", l);
            switchActivityIntent.putExtra("reporter", r);
            switchActivityIntent.putExtra("time", tm);
            switchActivityIntent.putExtra("date", dt);
            switchActivityIntent.putExtra("form", form);
            startActivity(switchActivityIntent);
        }
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePicker();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePicker();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
