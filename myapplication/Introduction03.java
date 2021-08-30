package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Introduction03 extends AppCompatActivity {

    ImageButton ib_mg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction03);


        ib_mg = findViewById(R.id.ib_nextpage);
        ib_mg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Introduction03.this, MatchGame.class
                );
                startActivity(i);
            }
        });
    }
}
