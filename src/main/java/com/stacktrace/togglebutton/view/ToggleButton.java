package com.stacktrace.togglebutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ToggleButton extends View{

    private ToggleState mState;
    private Bitmap mSlideBackground;
    private Bitmap mSwitchBackground;

    public void setToogleState(ToggleState state) {
        mState = state;
    }

    public enum ToggleState{
       Open, Close
    }

    public ToggleButton(Context context) {
        super(context);
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSlideBackgroundResource(int slide_button_background) {
        mSlideBackground  = BitmapFactory.decodeResource(getResources(), slide_button_background);
    }

    public void setSwitchBackgroundResource(int switch_background) {
        mSwitchBackground = BitmapFactory.decodeResource(getResources(), switch_background);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mSwitchBackground.getWidth(), mSwitchBackground.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mSwitchBackground, 0, 0, null);
        canvas.drawBitmap(mSlideBackground, 0, 0, null);
    }
}
