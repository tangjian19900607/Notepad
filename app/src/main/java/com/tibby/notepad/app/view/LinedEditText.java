package com.tibby.notepad.app.view;

/**
 * Author:tibby tang
 * Created on 4/12/14.
 * Email:tangjian19900607@gmail.com
 * QQ:562980080
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Defines a custom EditText View that draws lines between each line of text that is displayed.
 */
public class LinedEditText extends EditText {

    private static final String TAG = "UnderlineEditText";
    private Paint mPaint;
    private Rect mRect;
    private float mult = 1.5f;
    private float add = 2.0f;

    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinedEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setAntiAlias(true);
        this.setLineSpacing(add, mult);
    }

    @Override
    public void onDraw(Canvas canvas) {
        int count = getLineCount();
        for (int i = 0; i < count; i++) {
            getLineBounds(i, mRect);
            int baseline = (i + 1) * getLineHeight();
            canvas.drawLine(mRect.left, baseline, mRect.right, baseline, mPaint);
        }
        super.onDraw(canvas);
    }

}

