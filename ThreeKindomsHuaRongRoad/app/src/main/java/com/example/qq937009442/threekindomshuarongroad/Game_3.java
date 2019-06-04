package com.example.qq937009442.threekindomshuarongroad;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Game_3 extends AppCompatActivity {

    private TextView[] textView = new TextView[10];
    private Rectangle[] rectangle = new Rectangle[10];
    private TextView gStep;
    private Chronometer gTimer;
    private Button reStart;
    private Button backToChoose;

    private GameLoc gameLoc ;
    public int numStep;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_3);
        //初始化
        initView();
        initData();


    }
    private void initView(){
        textView[0] = findViewById(R.id.xy);
        textView[1] = findViewById(R.id.x1);
        textView[2] = findViewById(R.id.y1);
        textView[3] = findViewById(R.id.y2);
        textView[4] = findViewById(R.id.y3);
        textView[5] = findViewById(R.id.y4);
        textView[6] = findViewById(R.id.z1);
        textView[7] = findViewById(R.id.z2);
        textView[8] = findViewById(R.id.z3);
        textView[9] = findViewById(R.id.z4);
        gStep = findViewById(R.id.gcount);
        gTimer=findViewById(R.id.gtime);
        for (int i = 0; i <= 9; i++) {

            textView[i].setOnTouchListener(new View.OnTouchListener() {

                int left;
                int right;
                int top;
                int bottom;
                int beginX;
                int beginY;
                int lastX;
                int lastY;
                int move;
                Rectangle mRectangle = new Rectangle();

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            v.performClick();
                            lastX = (int) event.getRawX();
                            lastY = (int) event.getRawY();
                            beginX = lastX;
                            beginY = lastY;
                            left = v.getLeft();
                            right = v.getRight();
                            top = v.getTop();
                            bottom = v.getBottom();
                            //记录按下的部件的id
                            for (int ii = 0; ii <= 9; ii++) {
                                if (v.getId() == rectangle[ii].getId()) {
                                    mRectangle = rectangle[ii];
                                    Log.d("press", "" + mRectangle.getKind());
                                    break;
                                }
                            }

                            break;
                        case MotionEvent.ACTION_MOVE:
                            v.performClick();
                            //记录最好留下的触摸位置
                            lastX = (int) event.getRawX();
                            lastY = (int) event.getRawY();
                            break;
                        case MotionEvent.ACTION_UP:
                            v.performClick();
                            if (Math.abs(lastX - beginX) > 100 || Math.abs(lastY - beginY) > 100) {
                                move = Math.abs(-textView[2].getTop() + textView[2].getBottom()
                                        - textView[2].getRight() + textView[2].getLeft());
                                //判断移动方向
                                int dx = lastX - beginX;
                                int dy = lastY - beginY;
                                Log.d("direction-----x", "" + dx);
                                Log.d("direction-----y", "" + dy);
                                //移动
                                int replay = 0;
                                if (Math.abs(dx) >= Math.abs(dy)) {
                                    if (dx > 0) {
                                        Log.d("direction-----", "right");
                                        replay = mRectangle.recMove(gameLoc, "Right");
                                        if (replay == 1) {
                                            left = left + move;
                                            right = right + move;
                                        }
                                    } else {
                                        Log.d("direction-----", "left");
                                        replay = mRectangle.recMove(gameLoc, "Left");
                                        if (replay == 1) {
                                            left = left - move;
                                            right = right - move;
                                        }
                                    }
                                } else {
                                    if (dy < 0) {
                                        Log.d("direction-----", "up");
                                        replay = mRectangle.recMove(gameLoc, "Up");
                                        Log.d("movemove------------", "" + replay);
                                        if (replay == 1) {
                                            top = top - move;
                                            bottom = bottom - move;
                                        }
                                    } else {
                                        Log.d("direction-----", "down");
                                        replay = mRectangle.recMove(gameLoc, "Down");
                                        if (replay == 1) {
                                            top = top + move;
                                            bottom = bottom + move;
                                        }
                                    }
                                }
                                Log.d("mtouchlistener", "l__" + v.getLeft() + "t__" + v.getTop() + "r__" + v.getRight() +
                                        "b__" + v.getBottom() + "move__" + move);
                                //步数+1
                                if (replay == 1) {
                                    numStep++;
                                    gStep.setText(("" + numStep));
                                }
                                try {
                                    TimeUnit.MILLISECONDS.sleep(200);
                                } catch (InterruptedException e) {
                                }
                                v.layout(left, top, right, bottom);
                            }
                            //判断是否完成游戏
                            if(isWin()==1)
                            {
                                Game_win win = new Game_win();
                                win.show(getSupportFragmentManager(),"game_win");
                            }
                            break;

                    }
                    return false;
                }
            });

            textView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            textView[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //返回true标记消费事件，不继续往下传递。否则还会执行onClick点击事件
                    return false;
                }
            });
        }
        reStart=findViewById(R.id.restart);
        reStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.game_3);
                initView();
                initData();
            }
        });
        backToChoose = findViewById(R.id.backtochoose);
        backToChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToLevel=new Intent();
                setResult(RESULT_OK, backToLevel);
                finish();
            }
        });

    }

    private void initData() {

        //步数
        numStep = 0;
        gStep.setText((""+numStep));
        gameLoc=new GameLoc();
        //初始化各rectangle位置
        rectangle[0] = (new Rectangle(R.id.xy, 1, 4, 1));
        rectangle[1] = (new Rectangle(R.id.y1, 0, 3, 2));
        rectangle[2] = (new Rectangle(R.id.y2, 1, 2, 2));
        rectangle[3] = (new Rectangle(R.id.y3, 2, 2, 2));
        rectangle[4] = (new Rectangle(R.id.y4, 3, 3, 2));
        rectangle[5] = (new Rectangle(R.id.x1, 0, 0, 3));
        rectangle[6] = (new Rectangle(R.id.z1, 2, 0, 4));
        rectangle[7] = (new Rectangle(R.id.z2, 0, 1, 4));
        rectangle[8] = (new Rectangle(R.id.z3, 3, 1, 4));
        rectangle[9] = (new Rectangle(R.id.z4, 3, 0, 4));
        for (int i = 0; i <= 9; i++) {
            rectangle[i].recTake(gameLoc);
        }
        //计时器
        gTimer.setBase(SystemClock.elapsedRealtime());//计时器清零
        int hour = (int) ((SystemClock.elapsedRealtime() - gTimer.getBase()) / 1000 / 60);
        gTimer.setFormat("0"+String.valueOf(hour)+":%s");
        gTimer.start();
    }
    public int isWin()
    {
        if(rectangle[0].getRecX()==1&&rectangle[0].getRecY()==1)
        {
            return 1;
        }
        return 0;
    }

}
