package com.dengdeng123.klotski;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public class MyTouchView implements OnTouchListener, OnGestureListener {
    TextView tvTouched;

    GestureDetector detector;

    int tile_base_size_in_px;

    public MyTouchView(Context context, TextView tvTouched) {
        this.detector = new GestureDetector(context, this);

        this.tvTouched = tvTouched;

        this.tile_base_size_in_px = (int) (context.getResources().getDimension(R.dimen.tile_base_size));// 300px
    }

    // 用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发
    public boolean onDown(MotionEvent arg0) {
        Log.i("MyGesture", tvTouched.getId() + " : " + "onDown");

        // go();

        return true;
    }

    private void go() {
        if (MainActivity.b02 == null) {
            goWhenOneBlock();
        } else {
            goWhenTwoBlock();
        }
    }

    private void goWhenTwoBlock() {
        int top = tvTouched.getTop();
        int bottom = tvTouched.getBottom();
        int left = tvTouched.getLeft();
        int right = tvTouched.getRight();

        Block blockTouched = new Block(new int[]{left, top}, new int[]{right, top}, new int[]{right, bottom}, new int[]{left, bottom});

        if (blockTouched.rightTopPositionPx[0] == MainActivity.b01.leftTopPositionPx[0] && blockTouched.rightTopPositionPx[1] == MainActivity.b01.leftTopPositionPx[1] && blockTouched.rightBottomPositionPx[0] == MainActivity.b01.leftBottomPositionPx[0] && blockTouched.rightBottomPositionPx[1] == MainActivity.b01.leftBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向右移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.leftMargin += tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0] - tile_base_size_in_px, MainActivity.b01.leftTopPositionPx[1]};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0] - tile_base_size_in_px, MainActivity.b01.rightTopPositionPx[1]};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0] - tile_base_size_in_px, MainActivity.b01.rightBottomPositionPx[1]};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0] - tile_base_size_in_px, MainActivity.b01.leftBottomPositionPx[1]};
        }

        if (blockTouched.leftTopPositionPx[0] == MainActivity.b01.rightTopPositionPx[0] && blockTouched.leftTopPositionPx[1] == MainActivity.b01.rightTopPositionPx[1] && blockTouched.leftBottomPositionPx[0] == MainActivity.b01.rightBottomPositionPx[0] && blockTouched.leftBottomPositionPx[1] == MainActivity.b01.rightBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向左移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.leftMargin -= tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0] + tile_base_size_in_px, MainActivity.b01.leftTopPositionPx[1]};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0] + tile_base_size_in_px, MainActivity.b01.rightTopPositionPx[1]};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0] + tile_base_size_in_px, MainActivity.b01.rightBottomPositionPx[1]};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0] + tile_base_size_in_px, MainActivity.b01.leftBottomPositionPx[1]};
        }

        if (blockTouched.leftBottomPositionPx[0] == MainActivity.b01.leftTopPositionPx[0] && blockTouched.leftBottomPositionPx[1] == MainActivity.b01.leftTopPositionPx[1] && blockTouched.rightBottomPositionPx[0] == MainActivity.b01.rightTopPositionPx[0] && blockTouched.rightBottomPositionPx[1] == MainActivity.b01.rightTopPositionPx[1]) {
            Log.e("Jinhe", "可以向下移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.topMargin += tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0], MainActivity.b01.leftTopPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0], MainActivity.b01.rightTopPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0], MainActivity.b01.rightBottomPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0], MainActivity.b01.leftBottomPositionPx[1] - tile_base_size_in_px};
        }

        if (blockTouched.leftTopPositionPx[0] == MainActivity.b01.leftBottomPositionPx[0] && blockTouched.leftTopPositionPx[1] == MainActivity.b01.leftBottomPositionPx[1] && blockTouched.rightTopPositionPx[0] == MainActivity.b01.rightBottomPositionPx[0] && blockTouched.rightTopPositionPx[1] == MainActivity.b01.rightBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向上移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.topMargin -= tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0], MainActivity.b01.leftTopPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0], MainActivity.b01.rightTopPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0], MainActivity.b01.rightBottomPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0], MainActivity.b01.leftBottomPositionPx[1] + tile_base_size_in_px};
        }
    }

    private void goWhenOneBlock() {
        int top = tvTouched.getTop();
        int bottom = tvTouched.getBottom();
        int left = tvTouched.getLeft();
        int right = tvTouched.getRight();

        Block blockTouched = new Block(new int[]{left, top}, new int[]{right, top}, new int[]{right, bottom}, new int[]{left, bottom});

        if (blockTouched.rightTopPositionPx[0] == MainActivity.b01.leftTopPositionPx[0] && blockTouched.rightTopPositionPx[1] == MainActivity.b01.leftTopPositionPx[1] && blockTouched.rightBottomPositionPx[0] == MainActivity.b01.leftBottomPositionPx[0] && blockTouched.rightBottomPositionPx[1] == MainActivity.b01.leftBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向右移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.leftMargin += tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0] - tile_base_size_in_px, MainActivity.b01.leftTopPositionPx[1]};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0] - tile_base_size_in_px, MainActivity.b01.rightTopPositionPx[1]};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0] - tile_base_size_in_px, MainActivity.b01.rightBottomPositionPx[1]};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0] - tile_base_size_in_px, MainActivity.b01.leftBottomPositionPx[1]};
        }

        if (blockTouched.leftTopPositionPx[0] == MainActivity.b01.rightTopPositionPx[0] && blockTouched.leftTopPositionPx[1] == MainActivity.b01.rightTopPositionPx[1] && blockTouched.leftBottomPositionPx[0] == MainActivity.b01.rightBottomPositionPx[0] && blockTouched.leftBottomPositionPx[1] == MainActivity.b01.rightBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向左移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.leftMargin -= tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0] + tile_base_size_in_px, MainActivity.b01.leftTopPositionPx[1]};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0] + tile_base_size_in_px, MainActivity.b01.rightTopPositionPx[1]};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0] + tile_base_size_in_px, MainActivity.b01.rightBottomPositionPx[1]};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0] + tile_base_size_in_px, MainActivity.b01.leftBottomPositionPx[1]};
        }

        if (blockTouched.leftBottomPositionPx[0] == MainActivity.b01.leftTopPositionPx[0] && blockTouched.leftBottomPositionPx[1] == MainActivity.b01.leftTopPositionPx[1] && blockTouched.rightBottomPositionPx[0] == MainActivity.b01.rightTopPositionPx[0] && blockTouched.rightBottomPositionPx[1] == MainActivity.b01.rightTopPositionPx[1]) {
            Log.e("Jinhe", "可以向下移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.topMargin += tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0], MainActivity.b01.leftTopPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0], MainActivity.b01.rightTopPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0], MainActivity.b01.rightBottomPositionPx[1] - tile_base_size_in_px};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0], MainActivity.b01.leftBottomPositionPx[1] - tile_base_size_in_px};
        }

        if (blockTouched.leftTopPositionPx[0] == MainActivity.b01.leftBottomPositionPx[0] && blockTouched.leftTopPositionPx[1] == MainActivity.b01.leftBottomPositionPx[1] && blockTouched.rightTopPositionPx[0] == MainActivity.b01.rightBottomPositionPx[0] && blockTouched.rightTopPositionPx[1] == MainActivity.b01.rightBottomPositionPx[1]) {
            Log.e("Jinhe", "可以向上移动");

            LayoutParams lp = (LayoutParams) tvTouched.getLayoutParams();
            lp.topMargin -= tile_base_size_in_px;
            tvTouched.setLayoutParams(lp);

            MainActivity.b01.leftTopPositionPx = new int[]{MainActivity.b01.leftTopPositionPx[0], MainActivity.b01.leftTopPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.rightTopPositionPx = new int[]{MainActivity.b01.rightTopPositionPx[0], MainActivity.b01.rightTopPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.rightBottomPositionPx = new int[]{MainActivity.b01.rightBottomPositionPx[0], MainActivity.b01.rightBottomPositionPx[1] + tile_base_size_in_px};
            MainActivity.b01.leftBottomPositionPx = new int[]{MainActivity.b01.leftBottomPositionPx[0], MainActivity.b01.leftBottomPositionPx[1] + tile_base_size_in_px};
        }
    }

    public void onShowPress(MotionEvent e) {
        Log.i("MyGesture", tvTouched.getId() + " : " + "onShowPress");
    }

    // 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i("MyGesture", tvTouched.getId() + " : " + "onSingleTapUp");

        return true;
    }

    // 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("MyGesture", tvTouched.getId() + " : " + "onFling");

        // 参数解释：
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度，像素/秒
        // velocityY：Y轴上的移动速度，像素/秒

        // 触发条件 ：
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒

        // final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;
        // if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY)
        // {
        // // Fling left
        // Log.i("MyGesture", "Fling left");
        // }
        // else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY)
        // {
        // // Fling right
        // Log.i("MyGesture", "Fling right");
        // }
        // else if (e2.getY() - e1.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY)
        // {
        // // Fling down
        // Log.i("MyGesture", "Fling down");
        // }
        // else if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE && Math.abs(velocityY) > FLING_MIN_VELOCITY)
        // {
        // // Fling up
        // Log.i("MyGesture", "Fling up");
        // }

        return false;
    }

    // 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = e2.getX() - e1.getX();
        float y = e2.getY() - e1.getY();

        if (x > 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll 向右滑 ");
        } else if (x < 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll 向左滑");
        } else if (x == 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll x == 0");
        }

        if (y > 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll 向下滑 ");
        } else if (y < 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll 向上滑");
        } else if (y == 0) {
            Log.i("MyGesture", tvTouched.getId() + " : " + "onScroll y== 0");
        }

        go();

        return true;
    }

    // 用户长按触摸屏，由多个MotionEvent ACTION_DOWN触发
    public void onLongPress(MotionEvent e) {
        Log.i("MyGesture", tvTouched.getId() + " : " + "onLongPress");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}
