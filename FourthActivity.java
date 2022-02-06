package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];    // 그림의 투표 결과 저장하는 배열, 투표 결과를 ResultActivity로 전달(1)

        for (int i = 0; i < 9; i++)             // 초기화
            voteCount[i] = 0;

        // 9개의 이미지 버튼 객체배열(1-위젯 변수)
        ImageView image[] = new ImageView[9];


        // 그림의 제목을 ResultActivity로 전달(2)
        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };

        // 9개의 이미지버튼  ID 배열(2-위젯)
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

//------------------------------(3- 위젯변수와 위젯) (이벤트 처리)--------------------------------------
        for (int i = 0; i < imageId.length; i++) {
            final int index; // 주의! 꼭 필요함..
            index = i;                                                  // for문을 이용하여
            image[index] = (ImageView) findViewById(imageId[index]);   // (1) 위제 변수에 위제을 9번 대입

            image[index].setOnClickListener(new View.OnClickListener() { //(2) 이벤트 발생시 클래스를 위젯에 9번 정의
                public void onClick(View v) {

                    // 투표수 증가.
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }
//---------------------------------------------------------------------------------------
        Button btnFinish = (Button) findViewById(R.id.btnResult);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);  // 투표 결과를 ResultActivity로 보냄
                intent.putExtra("ImageName", imgName);  // 그림 제목을 ResultActivity로 보냄
                startActivity(intent);
            }
        });
//------------------------------------------------------------------------------------------
    }
}
