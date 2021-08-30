package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Link extends AppCompatActivity {

    ImageButton ib_hospitals, ib_scc, ib_ass, ib_ehc, ib_hksa, ib_mtr, ib_hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        ib_hospitals = findViewById(R.id.ib_hospitals);
        ib_scc = findViewById(R.id.ib_scc);
        ib_ass = findViewById(R.id.ib_ass);
        ib_ehc = findViewById(R.id.ib_ehc);
        ib_hksa = findViewById(R.id.ib_hksa);
        ib_mtr = findViewById(R.id.ib_mtr);
        ib_hp = findViewById(R.id.ib_hp);


        ib_hospitals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tungwahcsd.org/tc/our-services/elderly-services;category/55"));
                startActivity(i);
            }
        });

        ib_scc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.swd.gov.hk/tc/index/site_pubsvc/page_elderly/sub_csselderly/id_seniorciti/"));
                startActivity(i);
            }
        });

        ib_ass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.schsa.org.hk/tc/services/safe_services/index.html"));
                startActivity(i);
            }
        });

        ib_ehc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hkhs.com/tc/our-business/elderly-housing"));
                startActivity(i);
            }
        });

        ib_hksa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sage.org.hk/"));
                startActivity(i);
            }
        });

        ib_mtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mtr.com.hk/ch/customer/main/index.html"));
                startActivity(i);
            }
        });

        ib_hp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Link.this,HomePage.class
                );
                startActivity(i);
            }
        });
    }
}
