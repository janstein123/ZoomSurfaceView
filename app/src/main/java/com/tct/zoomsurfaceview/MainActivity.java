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
import android.view.View;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    private static final String TAG = "ZoomSurfaceView";
    private CustomSurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        surfaceView = (CustomSurfaceView) findViewById(R.id.zoom_surface_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(800, 800);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        draw(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged, format = "+format+", width = "+width+", height = "+height);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
    }

    private void draw(SurfaceHolder holder){
        Log.d(TAG, "draw");

        Paint p = new Paint();
        p.setColor(Color.BLUE);
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        }
        Log.d(TAG, "draw, bmp w = "+bitmap.getWidth()+", h = "+bitmap.getHeight());
        Canvas canvas = holder.lockCanvas();

        canvas.drawBitmap(bitmap, 0, 0, p);
//        canvas.drawLine(0, 0, 100, 100, p);
        holder.unlockCanvasAndPost(canvas);

    }

    int w = 200;
    int h = 200;

    public void onZoomInClicked(View view) {
        w += 50;
        h += 50;
        surfaceHolder.setFixedSize(w, h);
        draw(surfaceHolder);
    }

    public void onZoomOutClicked(View view) {
        w -= 50;
        h -= 50;
        surfaceHolder.setFixedSize(w, h);
        draw(surfaceHolder);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bitmap != null){
            bitmap.recycle();
        }
    }

}
