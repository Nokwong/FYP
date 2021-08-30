package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    ImageButton ib_mg,  ib_link, ib_si,ib_intriduction, ib_cmg, ib_cmgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);

        ib_mg = findViewById(R.id.ib_mg);
        ib_link = findViewById(R.id.ib_link);
        ib_si = findViewById(R.id.ib_si);
        ib_intriduction = findViewById(R.id.ib_introduction);
        ib_cmgi = findViewById(R.id.ib_cmgi);
        ib_cmg = findViewById(R.id.ib_cmg);

        ib_cmg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,ColorsGame.class);
                startActivity(i);
            }
        });

        ib_mg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, MatchGame.class);
                startActivity(i);
            }
        });

        ib_intriduction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Introduction01.class);
                startActivity(i);
            }
        });

        ib_si.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,ServicesIntroduction.class
                );
                startActivity(i);
            }
        });

        ib_link.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this,Link.class
                );
                startActivity(i);
            }
        });

    }
}

