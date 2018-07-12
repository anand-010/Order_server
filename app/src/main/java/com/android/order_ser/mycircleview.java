package com.android.order_ser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by anand on 6/20/2018.
 */

public class mycircleview extends View {
    private int circle_colour,label_col;
    private String circle_text;
    private Paint circe_paint;

    public mycircleview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        circe_paint =new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.mycircleview,0,0);
        try {


        circle_text = a.getString(R.styleable.mycircleview_circle_label);
        circle_colour = a.getInteger(R.styleable.mycircleview_circle_colour,0);
        label_col = a.getInteger(R.styleable.mycircleview_label_colour,0);
        }
        finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewwidthhalf = this.getMeasuredWidth()/2;
        int viewheighthalf = this.getMeasuredHeight()/2;
        int radious =0;
        if(viewwidthhalf>=viewheighthalf)
        {
            radious = viewheighthalf-10;
        }
        else {
            radious = viewwidthhalf-10;
        }
        circe_paint.setStyle(Paint.Style.FILL);
        circe_paint.setAntiAlias(true);
        circe_paint.setColor(circle_colour);
        canvas.drawCircle(viewwidthhalf,viewheighthalf,radious,circe_paint);
        circe_paint.setColor(label_col);
        circe_paint.setTextAlign(Paint.Align.CENTER);
        circe_paint.setTextSize(50);
        canvas.drawText(circle_text,viewwidthhalf,viewheighthalf,circe_paint);
    }
}
