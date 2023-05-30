package com.eraybd.project;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {

    static String connection_url = "jdbc:postgresql://localhost:5432/gazi_proje";
    static Connection conn = null;

    private Context context;

    public database(Context context) {
        this.context = context;
    }

    void connect() {
        new ConnectTask().execute();
    }

    void checkLogin(String email, String password) {
        new CheckLoginTask(email, password).execute();
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    private class ConnectTask extends AsyncTask<Void, Void, Connection> {
        @Override
        protected Connection doInBackground(Void... voids) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(connection_url,"postgres","5426");
                showToast("Bağlantı Gerçekleştirildi");
            } catch (SQLException e) {
                e.printStackTrace();
                conn = null;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return conn;
        }

        @Override
        protected void onPostExecute(Connection connection) {
            if (connection != null) {
                showToast("Bağlantı Gerçekleştirildi");
            } else {
                showToast("Bağlantı Başarısız");
            }
        }
    }

    private class CheckLoginTask extends AsyncTask<Void, Void, Boolean> {
        private String email;
        private String password;

        public CheckLoginTask(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (conn == null) {
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection(connection_url);
                    showToast("Bağlantı Gerçekleştirildi");
                } catch (SQLException e) {
                    e.printStackTrace();
                    conn = null;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn == null) {
                return false;
            }

            try {
                String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                boolean result = resultSet.next();
                statement.close();
                conn.close();
                return result;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                showToast("Giriş Başarılı");
            } else {
                showToast("Geçersiz E-posta veya Şifre");
            }
        }
    }
}
