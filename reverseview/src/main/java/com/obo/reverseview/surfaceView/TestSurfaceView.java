package com.obo.reverseview.surfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by obo on 15/12/6.
 */
public class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    SurfaceHolder surfaceHolder ;

    public TestSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        Canvas canvas = surfaceHolder.lockCanvas();

        //绘制之前先对画布进行翻转
        canvas.scale(-1,1, getWidth()/2,getHeight()/2);

        //开始自己的内容的绘制
        Paint paint = new Paint();
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("这是对SurfaceView的翻转",50,250,paint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

}
