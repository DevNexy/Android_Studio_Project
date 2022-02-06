package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, RECT=3,color_RED=4,color_GREEN =5, color_BLUE=6;
    static int curShape = LINE;
    static int curColor = color_RED;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu etc = menu.addSubMenu("색상 변경 >>");
        etc.add(0, 4, 0, "빨강");
        etc.add(0, 5, 0, "초록");
        etc.add(0, 6, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECT;
                return true;
            case 4:
                curColor=color_RED;
                return true;
            case 5:
                curColor=color_GREEN;
                return true;
            case 6:
                curColor=color_BLUE;
                return true;
        }
        return false;
    }

    private static class MyGraphicView extends View {
        ArrayList<MyShape> myShapeArrayList = new ArrayList<>();
        MyShape currentShape;
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();  // 화면이 무효화되고 onDraw() 메소드를 자동으로 실행한다.
            }
            return true;
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(10);
            paint.setStyle(Paint.Style.STROKE);

            currentShape = new MyShape(curShape, startX, startY, stopX, stopY, paint);
            myShapeArrayList.add(currentShape);

            for (MyShape cshape : myShapeArrayList)
                draw_shape(cshape, canvas);

            if (currentShape != null)
                draw_shape(currentShape, canvas);
        }
            public void draw_shape(MyShape myshape, Canvas canvas){
                switch (myshape.shape_type) {

                    case LINE:
                        canvas.drawLine(myshape.startX, myshape.startY, myshape.stopX, myshape.stopY, myshape.paint);
                        break;
                    case CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(myshape.stopX - myshape.startX, 2) + Math.pow(myshape.stopY - myshape.startY, 2));
                        canvas.drawCircle(myshape.startX, myshape.startY, radius,myshape.paint);
                        break;
                    case RECT:
                        Rect rect = new Rect(myshape.startX,myshape.startY, myshape.stopX, myshape.stopY);
                        canvas.drawRect(rect, myshape.paint);
                        break;
                }
            }
            private static class MyShape {
                int shape_type, startX, startY, stopX, stopY;
                Paint paint;

                public MyShape(int shape_type, int startX, int startY, int stopX, int stopY, Paint paint) {

                    this.shape_type = shape_type;
                    this.startX = startX;
                    this.startY = startY;
                    this.stopX = stopX;
                    this.stopY = stopY;
                    this.paint = paint;

                    switch (curColor) {

                        case color_RED:
                            paint.setColor(Color.RED);
                            break;
                        case color_BLUE:
                            paint.setColor(Color.BLUE);
                            break;
                        case color_GREEN:
                            paint.setColor(Color.GREEN);
                            break;
                    }
                }
            }
        }
    }


