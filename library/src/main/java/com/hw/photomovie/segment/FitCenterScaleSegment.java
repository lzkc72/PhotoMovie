package com.hw.photomovie.segment;

import com.hw.photomovie.opengl.GLESCanvas;

/**
 * Created by huangwei on 2018/9/12 0012.
 */
public class FitCenterScaleSegment extends FitCenterSegment {
    /**
     * 缩放动画范围
     */
    private float mScaleFrom;
    private float mScaleTo;

    private float mProgress;

    /**
     * @param duration  片段时长
     * @param scaleFrom 缩放范围
     * @param scaleTo   缩放范围
     */
    public FitCenterScaleSegment(int duration, float scaleFrom, float scaleTo) {
        super(duration);
        mScaleFrom = scaleFrom;
        mScaleTo = scaleTo;
    }

    @Override
    protected void onDataPrepared() {
        super.onDataPrepared();
    }

    @Override
    public void drawFrame(GLESCanvas canvas, float segmentProgress) {
        mProgress = segmentProgress;
        if (!mDataPrepared) {
            return;
        }
        drawBackground(canvas);
        float scale = mScaleFrom + (mScaleTo - mScaleFrom) * mProgress;
        drawContent(canvas, scale);
    }

    @Override
    public boolean showNextAsBackground() {
        return true;
    }
}