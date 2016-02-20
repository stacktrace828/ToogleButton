package com.stacktrace.togglebutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ToggleButton extends View {

    private ToggleState mState = ToggleState.Open;
    private Bitmap mSlideBackground;
    private Bitmap mSwitchBackground;
    private int mCurrentX;
    private boolean isSliding;
    private onToggleStateChangeListener mListener;

    public void setToogleState(ToggleState state) {
        mState = state;
    }

    public enum ToggleState {
        Open, Close
    }

    public ToggleButton(Context context) {
        super(context);
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSlideBackgroundResource(int slide_button_background) {
        mSlideBackground = BitmapFactory.decodeResource(getResources(), slide_button_background);
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
    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = (int) event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isSliding = true;
                break;
            case MotionEvent.ACTION_UP:
                isSliding = false;
                int centerX = mSwitchBackground.getWidth() / 2;
                if (mCurrentX > centerX) {
                    if (mState != ToggleState.Open)
                    {
                        mState = ToggleState.Open;
                        if (mListener != null){
                            mListener.onToggleStateChange(mState);
                        }
                    }
                } else {
                    if (mState != ToggleState.Close){
                        mState = ToggleState.Close;
                        if (mListener != null){
                            mListener.onToggleStateChange(mState);
                        }
                    }
                    
                }
                
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mSwitchBackground, 0, 0, null);

        if (isSliding) {
            int left = mCurrentX - mSlideBackground.getWidth() / 2;
            if (left < 0) {
                left = 0;
            }
            if (left > (mSwitchBackground.getWidth() - mSlideBackground.getWidth())) {
                left = mSwitchBackground.getWidth() - mSlideBackground.getWidth();
            }
            canvas.drawBitmap(mSlideBackground, left, 0, null);
        } else {
            if (mState == ToggleState.Open) {
                canvas.drawBitmap(mSlideBackground, mSwitchBackground.getWidth() - mSlideBackground.getWidth(), 0, null);
            } else {
                canvas.drawBitmap(mSlideBackground, 0, 0, null);
            }
        }
    }
    
    public void setOnToggleStateChangeListener(onToggleStateChangeListener listener){
        mListener = listener;
    }
    public interface onToggleStateChangeListener{
        void onToggleStateChange(ToggleState state);
    }
}
