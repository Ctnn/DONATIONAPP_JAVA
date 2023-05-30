package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class activity_donate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Button bt_location, btContinue;
    private static String selectedItem = "A"; //For .equals function, this cannot be null.

    private int donation_price;
    private int donation_prices_int;

    private int donation_quantity;
    private int donation_quantity_int;
    private int total_amount;

    private static String total_amount_payment;

    TextView tvDesc, tvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);



        btContinue = findViewById(R.id.dt_bt_continue);
        tvDesc = findViewById(R.id.dt_tv_descp);
        bt_location = findViewById(R.id.dt_bt_loc);
        tvValue = findViewById(R.id.dt_tv_value);

        bt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passToGMap();
            }
        });

        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTotalAmountPayment();
                passToPayment();
            }
        });

        String[] donation_desc = getResources().getStringArray(R.array.donation_desc);
        String[] donation_type = getResources().getStringArray(R.array.donation_type);
        String[] donation_prices = getResources().getStringArray(R.array.donation_prices);
        String[] donation_qua = getResources().getStringArray(R.array.donation_quantity);


        Spinner type_spinner = findViewById(R.id.dt_type_spinner);
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this, R.array.donation_type, android.R.layout.simple_spinner_item);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);
        type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = type_spinner.getSelectedItem().toString();

                if (selectedItem.equalsIgnoreCase(donation_type[0])) {}

                else if (selectedItem.equalsIgnoreCase(donation_type[1])) {
                    tvDesc.setText(donation_desc[0]);
                    donation_prices_int = Integer.parseInt(donation_prices[0]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[2])) {
                    tvDesc.setText(donation_desc[1]);
                    donation_prices_int = Integer.parseInt(donation_prices[1]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[3])) {
                    tvDesc.setText(donation_desc[2]);
                    donation_prices_int = Integer.parseInt(donation_prices[2]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[4])) {
                    tvDesc.setText(donation_desc[3]);
                    donation_prices_int = Integer.parseInt(donation_prices[3]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[5])) {
                    tvDesc.setText(donation_desc[4]);
                    donation_prices_int = Integer.parseInt(donation_prices[4]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[6])) {
                    tvDesc.setText(donation_desc[5]);
                    donation_prices_int = Integer.parseInt(donation_prices[5]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[7])) {
                    tvDesc.setText(donation_desc[6]);
                    donation_prices_int = Integer.parseInt(donation_prices[6]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[8])) {
                    tvDesc.setText(donation_desc[7]);
                    donation_prices_int = Integer.parseInt(donation_prices[7]);
                    setDonationPrice(donation_prices_int);
                    setTotalAmount();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });



        Spinner qua_spinner = findViewById(R.id.dt_qua_spinner);
        ArrayAdapter<CharSequence> qua_adapter = ArrayAdapter.createFromResource(this, R.array.donation_quantity, android.R.layout.simple_spinner_item);
        qua_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qua_spinner.setAdapter(qua_adapter);
        qua_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = qua_spinner.getSelectedItem().toString();

                if (selectedItem.equalsIgnoreCase(donation_qua[0])) {}

                else if (selectedItem.equalsIgnoreCase(donation_qua[1])) {
                    donation_quantity_int = Integer.parseInt(donation_qua[1]);
                    setDonationQuantity(donation_quantity_int);
                    setTotalAmount();
                }

                else if (selectedItem.equalsIgnoreCase(donation_qua[2])) {
                    donation_quantity_int = Integer.parseInt(donation_qua[2]);
                    setDonationQuantity(donation_quantity_int);
                    setTotalAmount();
                }

                else if (selectedItem.equalsIgnoreCase(donation_qua[3])) {
                    donation_quantity_int = Integer.parseInt(donation_qua[3]);
                    setDonationQuantity(donation_quantity_int);
                    setTotalAmount();
                }

                else if (selectedItem.equalsIgnoreCase(donation_qua[4])) {
                    donation_quantity_int = Integer.parseInt(donation_qua[4]);
                    setDonationQuantity(donation_quantity_int);
                    setTotalAmount();
                }

                else if (selectedItem.equalsIgnoreCase(donation_qua[5])) {
                    donation_quantity_int = Integer.parseInt(donation_qua[5]);
                    setDonationQuantity(donation_quantity_int);
                    setTotalAmount();
                }

                //Toast.makeText(getApplicationContext(), "You selected " + selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        Spinner loc_spinner = findViewById(R.id.dt_loc_map_spinner);
        ArrayAdapter<CharSequence> loc_adapter = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        loc_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loc_spinner.setAdapter(loc_adapter);
        loc_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = loc_spinner.getSelectedItem().toString();
                setLocation(selectedItem);
                //Toast.makeText(getApplicationContext(), "You selected " + selectedItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }

    public void passToGMap() {
        Intent intent = new Intent(this, activity_gmap.class);
        startActivity(intent);
    }

    public void passToPayment() {
        Intent intent = new Intent(this, activity_payment.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void setLocation(String sItem) {
        selectedItem = sItem;
    }

    public static String getLocation() {
        return selectedItem;
    }

    public void setDonationQuantity(int amount) {
        donation_quantity = amount;
    }

    public int getDonationQuantity() {
        return donation_quantity;
    }

    public void setDonationPrice(int amount) {
        donation_price = amount;
    }

    public int getDonationPrice() {
        return donation_price;
    }

    public void setTotalAmount() {
        total_amount = getDonationQuantity() * getDonationPrice();
        tvValue.setText("$" + Integer.toString(total_amount));
    }

    public void setTotalAmountPayment() {
        total_amount_payment = tvValue.getText().toString();
    }

    public static String getTotalAmountPayment() {
        return total_amount_payment;
    }

}