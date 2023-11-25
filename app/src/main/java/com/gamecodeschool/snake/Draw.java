package com.gamecodeschool.snake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Draw {
    private Bitmap mSize;
    private Bitmap bitMapApple;
    // A bitmap for each direction the head can face
    private Bitmap bitmapHeadRight;
    private Bitmap bitmapHeadLeft;
    private Bitmap bitmapHeadUp;
    private Bitmap bitmapHeadDown;

    // A bitmap for the body
    private Bitmap bitmapBody;


    public Draw(Bitmap bitMapApple, Bitmap bitmapHeadRight,
                Bitmap bitmapHeadLeft, Bitmap bitmapHeadUp, Bitmap bitmapHeadDown,
                Bitmap bitmapBody) {
        this.bitMapApple = bitMapApple;
        this.bitmapHeadRight = bitmapHeadRight;
        this.bitmapHeadUp = bitmapHeadUp;
        this.bitmapHeadDown = bitmapHeadDown;
        this.bitmapBody = bitmapBody;
    }

    public void drawApple(Canvas canvas, Paint paint , int appleSize, Point location) {
     canvas.drawBitmap(bitMapApple,
        location.x * appleSize,location.y *appleSize,paint);
    }

    public void drawSnake(Canvas canvas, Paint paint, int segmentSize,
                    ArrayList<Point> segmentLocations, Heading heading) {
            // Don't run this code if ArrayList has nothing in it

        if (!segmentLocations.isEmpty()) {
            switch (heading) {
                case RIGHT:
                    canvas.drawBitmap(bitmapHeadRight,
                            segmentLocations.get(0).x *segmentSize,
                            segmentLocations.get(0).y *segmentSize,paint);
                    break;

                case LEFT:
                    canvas.drawBitmap(bitmapHeadLeft,
                            segmentLocations.get(0).x *segmentSize,
                            segmentLocations.get(0).y *segmentSize,paint);
                    break;

                case UP:
                    canvas.drawBitmap(bitmapHeadUp,
                            segmentLocations.get(0).x *segmentSize,
                            segmentLocations.get(0).y *segmentSize,paint);
                    break;

                case DOWN:
                    canvas.drawBitmap(bitmapHeadDown,
                            segmentLocations.get(0).x *segmentSize,
                            segmentLocations.get(0).y *segmentSize,paint);
                    break;
            }

            for (int i = 1; i < segmentLocations.size(); i++) {
                canvas.drawBitmpa(bitmapBody, segmentLocations.get(i).x * segmentSize,
                                    segmentLocations.get(i).y * segmentSize, paint);
            }
        }
    }

}

