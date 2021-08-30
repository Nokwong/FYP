package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Services extends AppCompatActivity {

    ImageView iv_icon;
    ImageButton ib_back;
    TextView tv_name, tv_service;
    String[] Name = {"東華三院","長者咭","平安鐘","長者安居樂","耆康會","港鐵"};
    String[] Introduction = {"透過提供多元化及優質的服務，使長者安享富尊嚴及愉快的生活，達致圓滿人生。",
            "長者咭為長者提供一個享用政府部門，公共運輸機構及商號為長者提供的優惠，折扣和優先服務。此外，「長者咭計劃」亦提倡尊敬長者的精神。",
            "長者安居協會提供24小時全天候支援及關懷服務，只需按動主機按鈕(平安掣)，即可直駁協會「一線通平安鐘」服務熱線中心，由具經驗的關顧服務員提供緊急支援及非緊急服務。",
            "「長者安居樂」住屋計劃於1999年推出，兩個試驗項目分別在2003年及2004年落成，為中產長者提供集居住、康樂設施及醫療護理於一身的居所。",
            "耆康會於1977年成立，為居於院舍及社區之長者，提供長期照顧及支援服務，以確保長者安享晚年。",
            "港鐵一直致力為乘客提供安全、快捷、方便和可靠的鐵路服務。"};
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        iv_icon = findViewById(R.id.iv_icon);
        ib_back = findViewById(R.id.ib_back);
        tv_name = findViewById(R.id.tv_name);
        tv_service = findViewById(R.id.tv_service);

        Bundle extra = getIntent().getExtras();

        if ( extra != null ){
            data = extra.getString("select");
        }

        int number = Integer.parseInt(data);

        switch (number){
            case 0:
                iv_icon.setImageResource(R.drawable.ic_image103);
                break;
            case 1:
                iv_icon.setImageResource(R.drawable.ic_image105);
                break;
            case 2:
                iv_icon.setImageResource(R.drawable.ic_image106);
                break;
            case 3:
                iv_icon.setImageResource(R.drawable.ic_image101);
                break;
            case 4:
                iv_icon.setImageResource(R.drawable.ic_image102);
                break;
            case 5:
                iv_icon.setImageResource(R.drawable.ic_image104);
                break;
            default:
                break;
        }

        tv_name.setText(Name[number]);
        tv_service.setText(Introduction[number]);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Services.this,ServicesIntroduction.class);
                startActivity(i);
            }
        });




    }
}
