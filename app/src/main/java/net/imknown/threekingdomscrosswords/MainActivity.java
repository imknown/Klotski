package net.imknown.threekingdomscrosswords;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static Block b01;
    public static Block b02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int TILE_BASE_SIZE_IN_PX = (int) (getResources().getDimension(R.dimen.tile_base_size));// 300px
        // final int TILE_BASE_SIZE_IN_DP = (int) (getResources().getDimension(R.dimen.tile_base_size) / getResources().getDisplayMetrics().density + 0.5f);// 100dp

        // initMap01(TILE_BASE_SIZE_IN_PX);
        initMap02(TILE_BASE_SIZE_IN_PX);

        initTouchEvent();
    }

    private void initTouchEvent() {
        FrameLayout fl = (FrameLayout) findViewById(R.id.blocks_holder);
        int size = fl.getChildCount();

        for (int i = 0; i < size; i++) {
            TextView tv = (TextView) fl.getChildAt(i);

            tv.setOnTouchListener(new MyTouchView(this, tv));
        }
    }

    private void initMap01(int t) {
        setContentView(R.layout.activity_main);
        b01 = new Block(new int[]{2 * t, 2 * t}, new int[]{3 * t, 2 * t}, new int[]{3 * t, 3 * t}, new int[]{2 * t, 3 * t});
        b02 = null;
    }

    private void initMap02(int t) {
        setContentView(R.layout.activity_main_map_02);
        b01 = new Block(new int[]{1 * t, 4 * t}, new int[]{2 * t, 4 * t}, new int[]{2 * t, 5 * t}, new int[]{1 * t, 5 * t});
        b02 = new Block(new int[]{2 * t, 4 * t}, new int[]{3 * t, 4 * t}, new int[]{3 * t, 5 * t}, new int[]{2 * t, 5 * t});
    }
}
