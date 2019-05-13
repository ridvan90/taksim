package com.redblack.taksim.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.redblack.taksim.R;
import com.redblack.taksim.adapters.BildirimDataAdapter;
import com.redblack.taksim.model.BildirimData;

public class Bildirimler extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildirimler);

        BildirimData[] bildirimData = new BildirimData[]{

                new BildirimData("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"),
                new BildirimData("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"),
                new BildirimData("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"),
        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView_bildirimler);
        BildirimDataAdapter bildirimDataAdapter = new BildirimDataAdapter(bildirimData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bildirimDataAdapter);
    }
}
