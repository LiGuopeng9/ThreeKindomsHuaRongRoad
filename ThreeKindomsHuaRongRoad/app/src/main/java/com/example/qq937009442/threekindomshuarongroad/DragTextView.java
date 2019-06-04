package com.example.qq937009442.threekindomshuarongroad;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Sinaan on 2016/11/17.
 */
public class DragTextView extends android.support.v7.widget.AppCompatTextView{
    private int lastX ;
    private int lastY ;
    private int beginX ;
    private int beginY ;

    private static final int screenWidth = 3000;
    private static final int screenHeight = 3000;

    public DragTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void mlayout(int i,int i2,int i3,int i4)
    {
        this.layout(i,i2,i3,i4);
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event)
//    {
//        switch (event.getAction())
//        {
//            case MotionEvent.ACTION_DOWN:
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
//                beginX = lastX;
//                beginY = lastY;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int dx =(int)event.getRawX() - lastX;
//                int dy =(int)event.getRawY() - lastY;
//                int left = getLeft() + dx;
//                int top = getTop() + dy;
//                int right = getRight() + dx;
//                int bottom = getBottom() + dy;
//                if(left < 0){
//                    left = 0;
//                    right = left + getWidth();
//                }
//                if(right > screenWidth){
//                    right = screenWidth;
//                    left = right - getWidth();
//                }
//                if(top < 0){
//                    top = 0;
//                    bottom = top + getHeight();
//                }
//                if(bottom > screenHeight){
//                    bottom = screenHeight;
//                    top = bottom - getHeight();
//                }
//                layout(left, top, right, bottom);
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
//                break;
//            case MotionEvent.ACTION_UP:
//                if (Math.abs(lastX - beginX) < 10 && Math.abs(lastY - beginY) < 10)
//                    return super.onTouchEvent(event);
//                else
//                    return true;
//            default:
//                break;
//        }
//        return super.onTouchEvent(event);
//    }

}
