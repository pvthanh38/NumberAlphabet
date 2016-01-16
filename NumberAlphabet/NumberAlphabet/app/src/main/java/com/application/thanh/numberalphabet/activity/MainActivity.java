package com.application.thanh.numberalphabet.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.thanh.numberalphabet.R;
import com.application.thanh.numberalphabet.utils.FontStyle;

public class MainActivity extends AppCompatActivity {
    ImageView btnNumber, btnAlphabet, btnBubble;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        btnNumber = (ImageView)findViewById(R.id.imgNumber);
        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NumberActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left, R.anim.right);
            }
        });
        btnAlphabet = (ImageView)findViewById(R.id.imgAlphabet);
        btnAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AlphabetActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left, R.anim.right);
            }
        });
        btnBubble = (ImageView)findViewById(R.id.imgBubble);
        btnBubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BubbleActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left, R.anim.right);
            }
        });
    }


}
