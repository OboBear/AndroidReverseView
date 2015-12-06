package com.obo.reverseview.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by obo on 15/12/6.
 */
public class ReverseTextView extends TextView {
    public ReverseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.scale(-1, 1, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }
}
