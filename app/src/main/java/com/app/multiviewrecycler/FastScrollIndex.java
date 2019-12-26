package com.app.multiviewrecycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fastscroll.app.fastscrollalphabetindex.AlphabetIndexFastScrollRecyclerView;

public class FastScrollIndex extends AppCompatActivity {

    List<Data> listData = new ArrayList<>();
    DataAdapter adapter;
    Context mcontext;
    AlphabetIndexFastScrollRecyclerView alphabetIndexFastScrollRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastscroll);
        mcontext = this;

        listData.clear();
        listData.add(new Data("Avik"));
        listData.add(new Data("Arnab"));
        listData.add(new Data("Anikit"));
        listData.add(new Data("Rajjoy"));
        listData.add(new Data("Sandipan"));
        listData.add(new Data("Arindam"));
        listData.add(new Data("Abhishek"));
        Collections.sort(listData, new Comparator<Data>() {

            @Override
            public int compare(final Data object1, final Data object2) {
                return object1.getTitle().toUpperCase().compareTo(object2.getTitle().toUpperCase());
            }
        });
        alphabetIndexFastScrollRecyclerView = findViewById(R.id.recyclerView);
        alphabetIndexFastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new DataAdapter(mcontext, listData);
        alphabetIndexFastScrollRecyclerView.setAdapter(adapter);


    }
}
