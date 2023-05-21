package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

public class activity_login extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new database(this);
        emailEditText = findViewById(R.id.li_et_email);
        passwordEditText = findViewById(R.id.li_et_pw);

        TextView signup = findViewById(R.id.li_tv_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_signup);
            }
        });

        TextView forgotpw = findViewById(R.id.li_tv_forgotpw);
        forgotpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_forgotpw);
            }
        });

        findViewById(R.id.li_bt_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                try {
                    db.connect(); // Bağlantıyı yeniden oluştur
                    db.checkLogin(email, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Bağlantı hatası mesajı gösterilebilir veya işlemler yapılabilir
                }
            }
        });

    }
}
