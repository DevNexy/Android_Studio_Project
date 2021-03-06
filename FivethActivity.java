package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.EditText;

import java.util.Calendar;
public class FivethActivity extends AppCompatActivity {
    EditText et;
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal,rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute, tvContent;
    int selectYear, selectMonth, selectDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fiveth);

        setTitle("스케쥴 예약");
        //예약할 내용
        et = (EditText) findViewById(R.id.Edit1);

        //예약내용
        tvContent = (TextView) findViewById(R.id.tvContent);

        //버튼
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        //코로노미터
        chrono = (Chronometer) findViewById(R.id.chronometer1);

        //라디오버튼 2개
        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);

        //FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        calView = (CalendarView) findViewById(R.id.calendarView1);

        //텍스트뷰 중에서 연, 월, 일, 시, 분 숫자
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        //처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        //타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });
        // 버튼을 클릭하면 날짜,시간을 가져온다.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
                tvContent.setText("내용 : "+et.getText().toString());
            }
        });
    }
}

