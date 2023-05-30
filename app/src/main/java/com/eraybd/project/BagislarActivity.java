package com.eraybd.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class BagislarActivity extends AppCompatActivity {

    // ArrayList ile BagisAdlarini ve Açıklamalarını çekebileceğiz.

    ArrayList<BagisModel> bagisModelleri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagislar);




        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpBagisModelleri();

        BAGIS_RecyclerViewAdapter adapter = new BAGIS_RecyclerViewAdapter(this, bagisModelleri);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpBagisModelleri() {
        // İleride Database'den çekilecek verilerimizi Şuanlık values/strings.xml'den çekmekteyiz.
        String[] bagisAdlari = getResources().getStringArray(R.array.bagis_turu_paket_txt);
        String[] bagisAciklama = getResources().getStringArray(R.array.bagis_aciklama_txt);

        // Card'ların eklenmesi için verileri okutuyorum.
        for (int i = 0; i < bagisAdlari.length; i++) {
            bagisModelleri.add(new BagisModel(bagisAdlari[i], bagisAciklama[i]));
        }
    }
}
