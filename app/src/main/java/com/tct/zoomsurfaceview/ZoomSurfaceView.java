package com.tct.zoomsurfaceview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by tao.j on 2017/2/11.
 */

public class ZoomSurfaceView extends SurfaceView{
    private static final String TAG = "ZoomSurfaceView";

    public ZoomSurfaceView(Context context) {
        super(context);
    }

    public ZoomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d(TAG, "onTouchEvent, event = "+event);

        return true;
    }
}
