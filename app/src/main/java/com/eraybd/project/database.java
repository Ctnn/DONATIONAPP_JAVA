package com.eraybd.project;

import android.content.Context;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {

    // Veritabanı bağlantı kodları

    static String connection_url = "jdbc:postgresql://localhost:5432/gazi_proje";

    static Connection conn = null;

    private Context context; // Context'i saklamak için bir değişken tanımladık

    public database(Context context) {
        this.context = context;
    }

    void connect() throws SQLException {
        try {
            conn = DriverManager.getConnection(connection_url, "postgres", "5426");
            showToast("Bağlantı Gerçekleştirildi");
        } catch (SQLException e) {
            e.printStackTrace();
            showToast("Bağlantı Başarısız");
            showToast(String.valueOf(e));
            throw e; // Hata durumunda istisna yeniden fırlatılıyor
        }
    }

    void checkLogin(String email, String password) throws SQLException {
        connect();
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            showToast("Giriş Başarılı");
            // Giriş başarılı, yapılacak işlemler burada gerçekleştirilebilir
        } else {
            showToast("Geçersiz E-posta veya Şifre");
            // Giriş başarısız, hata mesajı gösterilebilir veya işlemler yapılabilir
        }

        statement.close();
        conn.close();
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
