package com.harkin.textreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okio.BufferedSource;
import okio.Okio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().getData() != null) {
            File doc = new File(getIntent().getData().getPath());

            List<String> strings = new ArrayList<>();
            try {
                BufferedSource bs = Okio.buffer(Okio.source(doc));

                while (!bs.exhausted()) {
                    strings.add(bs.readUtf8Line());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            TextAdapter textAdapter = new TextAdapter(strings, getLayoutInflater());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(textAdapter);
        }
    }
}
