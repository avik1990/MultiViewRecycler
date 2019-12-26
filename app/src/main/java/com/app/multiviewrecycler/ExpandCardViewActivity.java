package com.app.multiviewrecycler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fastscroll.app.fastscrollalphabetindex.AlphabetIndexFastScrollRecyclerView;

public class ExpandCardViewActivity extends AppCompatActivity {

    List<Data> listData1 = new ArrayList<>();
    List<Data> listData2 = new ArrayList<>();
    List<Data> listData3 = new ArrayList<>();
    MapAdapter mapAdapter;
    Context mcontext;
    RecyclerView recyclerView;
    HashMap<String, List<Data>> listHash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        mcontext = this;

        listData1.add(new Data("Avik", 20.1));
        listData1.add(new Data("Arnab", 21.1));
        listData1.add(new Data("Anikit", 2));
        listData2.add(new Data("Rajjoy", 3));
        listData2.add(new Data("Sandipan", 4));
        listData2.add(new Data("Arindam", 54));
        listData2.add(new Data("Abhishek", 23));

        listData3.add(new Data("Raju",23));
        listData3.add(new Data("Nagarjuna",21));

        listHash.put("Dry Wash", listData1);
        listHash.put("Iron", listData2);

        /*for (Map.Entry<String, List<Data>> entry : listHash.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue().size();
            Log.e("StringVal", key + " " + value);
        }*/

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mapAdapter = new MapAdapter(mcontext, listHash);
        recyclerView.setAdapter(mapAdapter);

    }
}
