package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class activity_payment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Button bt_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        bt_pay = findViewById(R.id.rp_bt_pay);

        setBtPay("Pay " + activity_donate.getTotalAmountPayment());

        Spinner m_spinner = findViewById(R.id.py_sp_m);
        ArrayAdapter<CharSequence> m_adapter = ArrayAdapter.createFromResource(this, R.array.cvv_months, android.R.layout.simple_spinner_item);
        m_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m_spinner.setAdapter(m_adapter);
        m_spinner.setOnItemSelectedListener(this);

        Spinner y_spinner = findViewById(R.id.py_sp_y);
        ArrayAdapter<CharSequence> y_adapter = ArrayAdapter.createFromResource(this, R.array.cvv_years, android.R.layout.simple_spinner_item);
        y_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        y_spinner.setAdapter(y_adapter);
        y_spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void setBtPay(String text) {
        bt_pay.setText(text);
    }
}