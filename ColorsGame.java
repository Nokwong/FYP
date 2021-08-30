package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ColorsGame extends AppCompatActivity {

    ImageView iv_arrow;
    Button button_color, pause;
    TextView tv_points;
    ProgressBar progressBar;

    Handler handler;
    Runnable runnable;

    Random r;

    private final static int STATE_BLUE = 1;
    private final static int STATE_RED = 2;
    private final static int STATE_YELLOW = 3;
    private final static int STATE_GREEN = 4;

    int buttonState = STATE_BLUE;
    int arrowState = STATE_BLUE;

    int currenTime = 4000;
    int startTime = 4000;

    int currentPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);

        button_color =   findViewById(R.id.button_color);

        pause = findViewById(R.id.pause);
        final MediaPlayer mp = MediaPlayer.create(ColorsGame.this, R.raw.background_music);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                    pause.setBackgroundResource(R.drawable.pause);
                }else{
                    mp.start();
                    pause.setBackgroundResource(R.drawable.play);
                }
            }
        });
        iv_arrow = findViewById(R.id.iv_arrow);
        tv_points = findViewById(R.id.tv_points);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(startTime);
        progressBar.setProgress(startTime);

        r = new Random();
        arrowState = r.nextInt(4) + 1;
        setArrowImage(arrowState);

        button_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonImage(setButtonPosition(buttonState));
            }
        });
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                currenTime = currenTime - 600;
                progressBar.setProgress(currenTime);
                if (currenTime > 0) {
                    handler.postDelayed(runnable, 800);
                } else {
                    if (buttonState == arrowState) {
                        currentPoints = currentPoints + 1;
                        tv_points.setText("顏色正確了：" + currentPoints + "個");

                        startTime = startTime - 100;
                        if (startTime < 1000) {
                            startTime = 2000;
                        }
                        progressBar.setMax(startTime);
                        currenTime = startTime;
                        progressBar.setProgress(currenTime);

                        arrowState = r.nextInt(4) + 1;
                        setArrowImage(arrowState);

                        handler.postDelayed(runnable, 800);
                    } else {
                        button_color.setEnabled(false);
                        Toast.makeText(ColorsGame.this, "游戲結束!",
                                Toast.LENGTH_SHORT).show();
                        mp.pause();

                        AlertDialog.Builder alert = new AlertDialog.Builder(ColorsGame.this);
                        alert.setCancelable(false).setPositiveButton("再玩一次!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(getApplicationContext(), HomePage.class);
                                startActivity(i);
                                finish();
                            }
                        }).setNegativeButton("離開游戲!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
            }
        };
        handler.postDelayed(runnable, 800);
    }
    private void setArrowImage(int state) {
        switch (state) {
            case STATE_BLUE:
                iv_arrow.setImageResource(R.drawable.blue_arrow);
                buttonState = STATE_BLUE;
                break;
            case STATE_RED:
                iv_arrow.setImageResource(R.drawable.red_arrow);
                buttonState = STATE_RED;
                break;
            case STATE_YELLOW:
                iv_arrow.setImageResource(R.drawable.yellow_arrow);
                buttonState = STATE_YELLOW;
                break;
            case STATE_GREEN:
                iv_arrow.setImageResource(R.drawable.green_arrow);
                buttonState = STATE_GREEN;
                break;
        }
    }
    private void setRotation(final Button image, final int drawable) {

        RotateAnimation rotateAnimation = new RotateAnimation(0,90,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {

                image.setBackgroundResource(drawable);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image.startAnimation(rotateAnimation);
    }
    private int setButtonPosition(int position) {
        position = position + 1;
        if (position == 5) {
            position = 1;
        }
        return position;
    }
    private void setButtonImage(int state) {
        switch (state) {
            case STATE_BLUE:
                setRotation(button_color, R.drawable.blue_button);
                buttonState = STATE_BLUE;
                final MediaPlayer mp3 = MediaPlayer.create(ColorsGame.this,R.raw.blue_sound);
                mp3.start();
                break;
            case STATE_GREEN:
                setRotation(button_color, R.drawable.green_button);
                buttonState = STATE_GREEN;
                final MediaPlayer mp4 = MediaPlayer.create(ColorsGame.this,R.raw.green_sound);
                mp4.start();
                break;
            case STATE_YELLOW:
                setRotation(button_color, R.drawable.yellow_button);
                buttonState = STATE_YELLOW;
                final MediaPlayer mp5 = MediaPlayer.create(ColorsGame.this,R.raw.yellow_sound);
                mp5.start();
                break;
            case STATE_RED:
                setRotation(button_color, R.drawable.red_button);
                buttonState = STATE_RED;
                final MediaPlayer mp6 = MediaPlayer.create(ColorsGame.this,R.raw.red_sound);
                mp6.start();
                break;
        }
    }
}