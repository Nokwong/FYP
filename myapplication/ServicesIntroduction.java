package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ServicesIntroduction extends AppCompatActivity {

    ImageButton ib_hp, ib_hospitals, ib_scc, ib_ass, ib_ehc, ib_hksa, ib_mtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si);


        ib_hospitals = findViewById(R.id.ib_hospitals);
        ib_scc = findViewById(R.id.ib_scc);
        ib_ass = findViewById(R.id.ib_ass);
        ib_ehc = findViewById(R.id.ib_ehc);
        ib_hksa = findViewById(R.id.ib_hksa);
        ib_mtr = findViewById(R.id.ib_mtr);
        ib_hp = findViewById(R.id.ib_hp);

        ib_hospitals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "0");
                startActivity(i);
            }
        });

        ib_scc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "1");
                startActivity(i);
            }
        });

        ib_ass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "2");
                startActivity(i);
            }
        });

        ib_ehc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "3");
                startActivity(i);
            }
        });

        ib_hksa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "4");
                startActivity(i);
            }
        });

        ib_mtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,Services.class);
                i.putExtra("select", "5");
                startActivity(i);
            }
        });

        ib_hp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ServicesIntroduction.this,HomePage.class);
                startActivity(i);
            }
        });

    }
}
