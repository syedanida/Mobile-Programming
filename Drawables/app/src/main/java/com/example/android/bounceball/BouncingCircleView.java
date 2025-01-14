package com.example.android.bounceball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

public class BouncingCircleView extends SurfaceView implements Runnable {

    private SurfaceHolder surfaceHolder;
    private List<Ball> balls;
    private boolean running;

    public BouncingCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        surfaceHolder = getHolder();
        balls = new ArrayList<>();
        balls.add(new Ball(100, 100, 5, 5, Color.BLUE, 50));
        balls.add(new Ball(200, 200, 8, 3, Color.RED, 75));
        balls.add(new Ball(300, 300, 4, 6, Color.YELLOW, 100));
        balls.add(new Ball(400, 400, 6, 2, Color.CYAN, 150));

        running = true;
    }

    @Override
    public void run() {
        while (running) {
            if (surfaceHolder.getSurface().isValid()) {
                Canvas canvas = surfaceHolder.lockCanvas();
                drawBalls(canvas);
                updatePositions();
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void drawBalls(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        for (Ball ball : balls) {
            Paint paint = new Paint();
            paint.setColor(ball.getColor());
            canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), paint);
        }
    }

    private void updatePositions() {
        for (Ball ball : balls) {
            ball.updatePosition(getWidth(), getHeight());
        }
    }

    public void pause() {
        running = false;
        while (true) {
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public void resume() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }


    private static class Ball {
        private float x, y;
        private float xSpeed, ySpeed;
        private int color;
        private int radius;

        public Ball(float x, float y, float xSpeed, float ySpeed, int color, int radius) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
            this.color = color;
            this.radius = radius;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public int getColor() {
            return color;
        }

        public int getRadius() {
            return radius;
        }

        public void updatePosition(int canvasWidth, int canvasHeight) {
            x += xSpeed;
            y += ySpeed;
            if (x - radius < 0 || x + radius > canvasWidth) {
                xSpeed = -xSpeed;
            }
            if (y - radius < 0 || y + radius > canvasHeight) {
                ySpeed = -ySpeed;
            }
        }
    }
}
