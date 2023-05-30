package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Random;

public class activity_receive extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static Button bt_location;
    private static String selectedItem = "A"; //For .equals function, this cannot be null.

    EditText etDate;
    Button btDate;
    TextView etID, tvDesc;
    DatePickerDialog.OnDateSetListener setListener;

    Random random = new Random();
    String randomNumber = String.valueOf(random.nextInt(999999999));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        tvDesc = findViewById(R.id.rc_tv_descp);
        btDate = findViewById(R.id.rc_bt_date);
        etDate = findViewById(R.id.rc_et_date);
        etID = findViewById(R.id.dt_tv_id);
        etID.setText(randomNumber);


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        activity_receive.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day+"/"+month+"/"+year;
                etDate.setText(date);
            }
        };

        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        activity_receive.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        bt_location = findViewById(R.id.rc_bt_loc);
        bt_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passToMap();
            }
        });

        String[] donation_desc = getResources().getStringArray(R.array.donation_desc);
        String[] donation_type = getResources().getStringArray(R.array.donation_type);


        Spinner type_spinner = findViewById(R.id.rc_type_spinner);
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this, R.array.donation_type, android.R.layout.simple_spinner_item);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);
        type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = type_spinner.getSelectedItem().toString();

                if (selectedItem.equalsIgnoreCase(donation_type[1])) {
                    tvDesc.setText(donation_desc[0]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[2])) {
                    tvDesc.setText(donation_desc[1]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[3])) {
                    tvDesc.setText(donation_desc[2]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[4])) {
                    tvDesc.setText(donation_desc[3]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[5])) {
                    tvDesc.setText(donation_desc[4]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[6])) {
                    tvDesc.setText(donation_desc[5]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[7])) {
                    tvDesc.setText(donation_desc[6]);
                }
                else if (selectedItem.equalsIgnoreCase(donation_type[8])) {
                    tvDesc.setText(donation_desc[7]);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });



        Spinner loc_spinner = findViewById(R.id.rc_loc_map_spinner);
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

    public void passToMap() {
        Intent intent = new Intent(this, activity_gmap.class);
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

}