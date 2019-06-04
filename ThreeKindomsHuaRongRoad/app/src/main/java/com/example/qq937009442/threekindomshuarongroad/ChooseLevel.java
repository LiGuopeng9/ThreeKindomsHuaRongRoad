package com.example.qq937009442.threekindomshuarongroad;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseLevel extends AppCompatActivity {
    final String LOG_TAG="chooselevel---";

    private RecyclerView mLevelRevclerView;
    private ArrayList<Level> mLevelData;
    private LevelListAdapter mAdapter;
    private CardView mCardView;
    private Button backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreat", "onCreate chooseLevel");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_level);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mLevelRevclerView = findViewById(R.id.chooseLevelRevyclerView);
        mLevelData = new ArrayList<>();
        mLevelRevclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new LevelListAdapter(mLevelData, this);
        mLevelRevclerView.setAdapter(mAdapter);
        initializeLevelData();
        mAdapter.setmOnItemClickListener(new LevelListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                itemclick(view, position);
            }
        });
        backToHome=findViewById(R.id.backtohome);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent();
                setResult(RESULT_OK, back);
                finish();
            }
        });
    }

    private void itemclick(View view, int position) {
        Log.d("itemclick  view", "" + view);
        Log.d("itemclick  position",
                "" + mLevelData.get(position).getLevelName());
        Intent intent;
        switch (mLevelData.get(position).getNum()) {

            case 0:
                Log.d("itemclick ", "0000000000");
                intent =  new Intent(this, Game_1.class);
                startActivityForResult(intent,position);
                break;
            case 1:
                Log.d("itemclick ", "0000000000");
                intent =  new Intent(this, Game_2.class);
                startActivityForResult(intent,position);
                break;
            case 2:
                Log.d("itemclick ", "0000000000");
                intent =  new Intent(this, Game_3.class);
                startActivityForResult(intent,position);
                break;
            case 3:
                Log.d("itemclick ", "0000000000");
                intent =  new Intent(this, Game_4.class);
                startActivityForResult(intent,position);
                break;
        }


    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void initializeLevelData() {
        String[] levelName = getResources().getStringArray(R.array.levelname);
        TypedArray levelImage = getResources().obtainTypedArray(R.array.levelimage);
        mLevelData.clear();
        for (int i = 0; i < levelName.length; i++) {
            mLevelData.add(new Level(levelName[i],
                    levelImage.getResourceId(i, 0), i));
        }
        levelImage.recycle();
        mAdapter.notifyDataSetChanged();
        Log.d("initializeLevelData", "initializeLevelData");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onDestory");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onStop");
    }
}
