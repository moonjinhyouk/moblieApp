package com.example.anew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private Path path;

    private static class Stroke {
        Path path;
        Paint paint;

        Stroke(Path path, Paint paint) {
            this.path = path;
            this.paint = paint;
        }
    }

    private List<Stroke> strokes = new ArrayList<>();
    private int currentColor = 0xFF000000;
    private float strokeWidth = 10f;

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(currentColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(strokeWidth);
    }

    public void setPaintColor(int color) {
        currentColor = color;
        initPaint();
    }

    public void setStrokeWidth(float width) {
        strokeWidth = width;
        initPaint();
    }

    public void clearCanvas() {
        strokes.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Stroke stroke : strokes) {
            canvas.drawPath(stroke.path, stroke.paint);
        }
        if (path != null) {
            canvas.drawPath(path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x, y);
                Paint newPaint = new Paint(paint); // 현재 스타일 복사
                strokes.add(new Stroke(path, newPaint));
                invalidate();
                return true;

            case MotionEvent.ACTION_MOVE:
                if (path != null) {
                    path.lineTo(x, y);
                }
                invalidate();
                return true;

            case MotionEvent.ACTION_UP:
                path = null;
                invalidate();
                return true;

            default:
                return false;
        }
    }
}
