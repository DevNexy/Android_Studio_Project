package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        // 앞 화면에서 보낸 투표 결과 값을 받는다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");           // 투표 결과를 가져옴
        String[] imageName = intent.getStringArrayExtra("ImageName");  // 그림 이름을 가져옴

        // 9개의 TextView, RatingBar 객체배열(1-위젯 변수)
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        // 9개의 TextView, RatingBar ID 배열(2-위젯)
        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };

        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        // TextView, RatingBar 개체 찾기.(3-위젯변수와 위젯)--------------------------------------------------
        for (int i = 0; i < voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);          //TextView 위제 변수에 위젯을 9번 대입
            rbar[i] = (RatingBar) findViewById(rbarID[i]);    //RatingBar위제 변수에 위젯을 9번 대입
        }


        // 각 TextVeiw 및 RatingBar에 넘겨 받은 값을 반영하여 표시.------------------------------------
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);             //TextView에 그림 제목 출력
            rbar[i].setRating((float) voteResult[i]);   //RatingBar에 투표수를 적용하여 출력
        }

// 투표 종료버튼을 클릭했을 때 종료------------------------------------------------------
        Button btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });
    }
}
