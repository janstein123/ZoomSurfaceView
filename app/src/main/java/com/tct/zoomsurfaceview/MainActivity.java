package com.tct.zoomsurfaceview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private static final String TAG = "ZoomSurfaceView";
    private ZoomSurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        surfaceView = (ZoomSurfaceView) findViewById(R.id.zoom_surface_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(100, 100);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        Canvas canvas = holder.lockCanvas();
        draw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged, format = "+format+", width = "+width+", height = "+height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
    }

    private void draw(Canvas canvas){
        Log.d(TAG, "draw");

        Paint p = new Paint();
        p.setColor(Color.BLUE);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Log.d(TAG, "draw, bmp w = "+bmp.getWidth()+", h = "+bmp.getHeight());

        canvas.drawBitmap(bmp, 0, 0, p);
//        canvas.drawLine(0, 0, 100, 100, p);
        bmp.recycle();
    }
}
