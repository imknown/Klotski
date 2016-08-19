package com.dengdeng123.klotski;

import java.io.Serializable;

public class Block implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 左上角坐标
     */
    public int[] leftTopPositionPx;

    /**
     * 右上角坐标
     */
    public int[] rightTopPositionPx;

    /**
     * 右下角坐标
     */
    public int[] rightBottomPositionPx;

    /**
     * 左下角坐标
     */
    public int[] leftBottomPositionPx;

    public Block(int[] leftTopPositionPx, int[] rightTopPositionPx, int[] rightBottomPositionPx, int[] leftBottomPositionPx) {
        this.leftTopPositionPx = leftTopPositionPx;
        this.rightTopPositionPx = rightTopPositionPx;
        this.rightBottomPositionPx = rightBottomPositionPx;
        this.leftBottomPositionPx = leftBottomPositionPx;
    }
}
