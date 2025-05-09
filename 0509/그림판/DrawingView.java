package com.example.sketchapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {

    private Paint paint;
    private Path path;  // 그림을 그릴 경로
    private List<Path> paths;  // 여러 경로를 저장할 리스트
    private List<Paint> pathPaints;  // 경로별로 다른 Paint 객체를 저장

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);  // 기본 색상
        paint.setStrokeWidth(10);  // 기본 브러시 굵기
        paint.setStyle(Paint.Style.STROKE);  // 그리기 스타일
        paint.setAntiAlias(true);  // 선을 부드럽게

        path = new Path();  // 새로운 경로 객체 생성
        paths = new ArrayList<>();  // 경로 리스트 초기화
        pathPaints = new ArrayList<>();  // 경로에 대한 Paint 리스트 초기화
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 리스트에 저장된 모든 경로와 그 경로에 사용된 Paint로 그리기
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i), pathPaints.get(i));
        }
        // 현재 그려지고 있는 경로 그리기
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();  // 새로운 경로 시작
                path.moveTo(currentX, currentY);  // 시작 위치
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(currentX, currentY);  // 선을 그리기
                break;
            case MotionEvent.ACTION_UP:
                paths.add(path);  // 경로 리스트에 추가
                pathPaints.add(new Paint(paint));  // 경로에 사용된 Paint 저장
                break;
        }

        invalidate();  // 뷰를 새로 고침하여 화면을 업데이트
        return true;
    }

    // 브러시 색상 설정
    public void setBrushColor(String colorHex) {
        paint.setColor(Color.parseColor(colorHex));  // 색상 변경
    }

    // 브러시 굵기 설정
    public void setBrushWidth(int width) {
        paint.setStrokeWidth(width);  // 굵기 변경
    }

    // 캔버스 지우기
    public void clearCanvas() {
        paths.clear();  // 경로 리스트를 즉시 비우기
        pathPaints.clear();  // Paint 리스트도 비우기
        path.reset();  // 현재 그리던 경로를 리셋
        invalidate();  // 화면 즉시 새로 고침
    }
}
