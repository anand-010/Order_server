package com.android.order_ser;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.GestureDetector;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by anand on 5/31/2018.
 */

public class myview extends CircleImageView {

    private Paint paint = new Paint();
    private Path path = new Path();
    Context context;
    float radious;
    GestureDetector gestureDetector;

    public myview(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(radious);
        paint.setColor(Color.BLACK);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText("hai ebery one",-10,-10,paint);
        super.onDraw(canvas);

    }
}
