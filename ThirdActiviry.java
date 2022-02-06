package com.cookandroid.intentall;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;

public class ThirdActiviry extends AppCompatActivity {
    final static int Blur1 = 1,Blur2 = 2, Blur3=3,Blur4=4;
    static int BlurSelect = Blur1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("포토샵");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "blur1");
        menu.add(0, 2, 0, "blur2");
        menu.add(0, 3, 0, "blur3");
        menu.add(0, 4, 0, "blur4");

        SubMenu subMenu = menu.addSubMenu("배경색 선택");
        subMenu.add(0,5,0,"Color1");
        subMenu.add(0,6,0,"Color2");
        subMenu.add(0,7,0,"Color3");
        subMenu.add(0,8,0,"Color4");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                BlurSelect = Blur1;
                break;
            case 2:
                BlurSelect = Blur2;
                break;
            case 3:
                BlurSelect = Blur3;
                break;
            case 4:
                BlurSelect = Blur4;
                break;
            case 5:

        }
        return true;
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);


            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            //ColorFilter 만들기
            Paint paint = new Paint();

            BlurMaskFilter bMask;

            switch(BlurSelect){
                case Blur1:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    invalidate();
                    break;
                case Blur2:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    picture.recycle(); // 비트맵 리소스 해제
                    invalidate();
                    break;
                case Blur3:
                    bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    picture.recycle(); // 비트맵 리소스 해제
                    invalidate();
                    break;
                case Blur4:
                    bMask = new BlurMaskFilter (30, BlurMaskFilter.Blur.SOLID);
                    paint.setMaskFilter(bMask);
                    canvas.drawBitmap(picture, picX, picY, paint);
                    picture.recycle(); // 비트맵 리소스 해제
                    invalidate();
                    break;
            }
        }
    }
}

