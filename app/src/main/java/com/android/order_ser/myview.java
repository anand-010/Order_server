package com.android.order_ser;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by anand on 5/31/2018.
 */

public class myview extends CircleImageView {
    private int circle_colour,label_col;
    private String circle_text;
    private Paint circe_paint;


    public myview(Context context, AttributeSet attrs) {
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
        int viewheighthalf =this.getMeasuredHeight()/2;
        int viewwidthhal = this.getMeasuredWidth()*3/4;
        int viewheighthal =this.getMeasuredHeight()/4;
        int radious =0;
        int textsize =0;
        if(viewwidthhalf>=viewheighthalf)
        {
            radious = viewheighthalf/2;
        }
        else {
            radious = viewwidthhalf/2;
        }
        textsize= radious-10;
        circe_paint.setStyle(Paint.Style.FILL);
        circe_paint.setAntiAlias(true);
        circe_paint.setColor(circle_colour);
        canvas.drawCircle(viewwidthhal,viewheighthal,radious,circe_paint);
        circe_paint.setColor(label_col);
        circe_paint.setTextAlign(Paint.Align.CENTER);
        circe_paint.setTextSize(textsize);

        canvas.drawText(circle_text,viewwidthhal,viewheighthal+(textsize/3),circe_paint);
    }
}
