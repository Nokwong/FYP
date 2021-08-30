package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Introduction02 extends AppCompatActivity {

    ImageButton ib_nextpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction02);


        ib_nextpage = findViewById(R.id.ib_nextpage);
        ib_nextpage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Introduction02.this, Introduction03.class
                );
                startActivity(i);
            }
        });
    }
}
