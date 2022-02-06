package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.os.Bundle;


import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;
import android.widget.Switch;
import android.widget.ImageView;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        ImageView iv = (ImageView) findViewById(R.id.img);
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        Button btnNewActivity1 = (Button) findViewById(R.id.btnNewActivity1);
        Button btnNewActivity2 = (Button) findViewById(R.id.btnNewActivity2);
        Button btnNewActivity3 = (Button) findViewById(R.id.btnNewActivity3);
        Button btnNewActivity4 =(Button) findViewById(R.id.btnNewActivity4);
        Button btnNewActivity5 =(Button) findViewById(R.id.btnNewActivity5);
        Button btnSelf =(Button) findViewById(R.id.btnSelf);
        Button btnName =(Button) findViewById(R.id.btnName);
        Button btnMajor =(Button) findViewById(R.id.btnMajor);
        Button btnSite =(Button) findViewById(R.id.btnSite);
        Button btnCareer =(Button) findViewById(R.id.btnCareer);
        Button btnGoal =(Button) findViewById(R.id.btnGoal);
        Button btnAge =(Button) findViewById(R.id.btnAge);
        Button btnBlood =(Button) findViewById(R.id.btnBlood);
        Switch schIntroduce = findViewById(R.id.schIntroduce);

        btnSelf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnSite.setVisibility(View.VISIBLE);
                btnName.setVisibility(View.VISIBLE);
                btnMajor.setVisibility(View.VISIBLE);
                btnCareer.setVisibility(View.VISIBLE);
                btnGoal.setVisibility(View.VISIBLE);
                btnAge.setVisibility(View.VISIBLE);
                btnBlood.setVisibility(View.VISIBLE);
            }
        });
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"송지원",Toast.LENGTH_LONG).show();
            }
        });
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"22",Toast.LENGTH_LONG).show();
            }
        });
        btnBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"O형",Toast.LENGTH_LONG).show();
            }
        });
        btnMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"빅데이터 전공",Toast.LENGTH_LONG).show();
            }
        });
        btnCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"게임 개발",Toast.LENGTH_LONG).show();
            }
        });
        btnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"A+",Toast.LENGTH_LONG).show();
            }
        });
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mustit.co.kr/"));
                startActivity(intent);
            }
        });
        schIntroduce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(schIntroduce.isChecked() == true){
                    btnSite.setVisibility(View.VISIBLE);
                    btnName.setVisibility(View.VISIBLE);
                    btnMajor.setVisibility(View.VISIBLE);
                    btnCareer.setVisibility(View.VISIBLE);
                    btnGoal.setVisibility(View.VISIBLE);
                    btnAge.setVisibility(View.VISIBLE);
                    btnBlood.setVisibility(View.VISIBLE);
                    iv.setImageResource(R.drawable.jiwon);
                    iv.setVisibility(View.VISIBLE);
                }else{
                    btnSite.setVisibility(View.GONE);
                    btnName.setVisibility(View.GONE);
                    btnMajor.setVisibility(View.GONE);
                    btnCareer.setVisibility(View.GONE);
                    btnGoal.setVisibility(View.GONE);
                    btnAge.setVisibility(View.GONE);
                    btnBlood.setVisibility(View.GONE);
                    iv.setVisibility(View.GONE);
                }
            }
        });
        btnNewActivity.setOnClickListener(new View.OnClickListener() {//포토샵
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
        btnNewActivity1.setOnClickListener(new View.OnClickListener() {//그림판
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), ThirdActiviry.class);
                startActivity(intent1);
            }
        });
        btnNewActivity2.setOnClickListener(new View.OnClickListener() {//명화투표
            public void onClick(View v) {

                Intent intent2 = new Intent(getApplicationContext(), FourthActivity.class);
                startActivity(intent2);
            }
        });
        btnNewActivity3.setOnClickListener(new View.OnClickListener() {//예약앱
            public void onClick(View v) {

                Intent intent3 = new Intent(getApplicationContext(), FivethActivity.class);
                startActivity(intent3);
            }
        });
        btnNewActivity4.setOnClickListener(new View.OnClickListener() {//계산기
            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), SixthActivity.class);
                startActivity(intent4);
            }
        });
        btnNewActivity5.setOnClickListener(new View.OnClickListener() {//일기장
            public void onClick(View v) {

                Intent intent5 = new Intent(getApplicationContext(), SeventhActivity.class);
                startActivity(intent5);
            }
        });
//        btnNewActivity4.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                SlidingDrawer drawer = (SlidingDrawer)findViewById(R.id.slidingDrawer1);
//                drawer.animateClose();
//            }
//        });
    }

}