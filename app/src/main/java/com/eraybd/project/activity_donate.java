package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class activity_donate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        Spinner type_spinner = findViewById(R.id.dt_type_spinner);
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this, R.array.donation_type, android.R.layout.simple_spinner_item);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);
        type_spinner.setOnItemSelectedListener(this);

        Spinner qua_spinner = findViewById(R.id.dt_qua_spinner);
        ArrayAdapter<CharSequence> qua_adapter = ArrayAdapter.createFromResource(this, R.array.donation_quantity, android.R.layout.simple_spinner_item);
        qua_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qua_spinner.setAdapter(qua_adapter);
        qua_spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}