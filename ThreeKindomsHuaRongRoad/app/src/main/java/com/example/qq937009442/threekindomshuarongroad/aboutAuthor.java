package com.example.qq937009442.threekindomshuarongroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class aboutAuthor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_author);
    }

    public void backToHome(View view) {
        Intent back=new Intent();
        setResult(RESULT_OK, back);
        finish();
    }
}
