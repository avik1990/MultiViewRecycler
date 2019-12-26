package com.app.multiviewrecycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.multiviewrecycler.crousel.MainCrouselActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIndex, btnCrousel, btnExpandCard;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        btnIndex = findViewById(R.id.btnIndex);
        btnCrousel = findViewById(R.id.btnCrousel);
        btnExpandCard = findViewById(R.id.btnExpandCard);

        btnIndex.setOnClickListener(this);
        btnCrousel.setOnClickListener(this);
        btnExpandCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnIndex) {
            Intent i = new Intent(context, FastScrollIndex.class);
            startActivity(i);
        } else if (v == btnCrousel) {
            Intent i = new Intent(context, MainCrouselActivity.class);
            startActivity(i);
        } else if (v == btnExpandCard) {
            Intent i = new Intent(context, ExpandCardViewActivity.class);
            startActivity(i);
        }
    }
}
