package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view1 = findViewById(R.id.my_view);
        View view2 = findViewById(R.id.my_view2);
        View view3 = findViewById(R.id.my_view3);
        View view4 = findViewById(R.id.my_view4);
        View view5 = findViewById(R.id.my_view5);
        View view6 = findViewById(R.id.my_view6);
        View view7 = findViewById(R.id.my_view7);
        View view8 = findViewById(R.id.my_view8);
        View view9 = findViewById(R.id.my_view9);
        View view10 = findViewById(R.id.my_view10);
        View view11= findViewById(R.id.my_view11);
        View view12 = findViewById(R.id.my_view12);


        ImageView imageView = findViewById(R.id.box_image4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getApplicationContext(), BagislarActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });





    }


}