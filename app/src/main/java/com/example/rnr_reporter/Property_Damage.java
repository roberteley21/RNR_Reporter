package com.example.rnr_reporter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class Property_Damage extends AppCompatActivity {

    Button submit;
    EditText name, type, description, location, reporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_damage);

        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        description = findViewById(R.id.description);
        location =  findViewById(R.id.location);
        reporter = findViewById(R.id.reporter);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchSubmit();
            }
        });
    }

    private void switchSubmit() {
        String n, t, d, l, r;
        n = name.getText().toString();
        t = type.getText().toString();
        d = description.getText().toString();
        l = location.getText().toString();
        r = reporter.getText().toString();
        Intent switchActivityIntent = new Intent(this, Summary.class);
        switchActivityIntent.putExtra("name", n);
        switchActivityIntent.putExtra("type", t);
        switchActivityIntent.putExtra("description", d);
        switchActivityIntent.putExtra("location", l);
        switchActivityIntent.putExtra("reporter", r);
        startActivity(switchActivityIntent);
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
