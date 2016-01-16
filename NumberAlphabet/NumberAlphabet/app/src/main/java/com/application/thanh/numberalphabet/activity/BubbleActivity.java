package com.application.thanh.numberalphabet.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.application.thanh.numberalphabet.R;
import com.application.thanh.numberalphabet.utils.AnimationIntent;
import com.application.thanh.numberalphabet.utils.DragAndDrop;
import com.application.thanh.numberalphabet.utils.FontStyle;
import com.application.thanh.numberalphabet.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Random;

public class BubbleActivity extends AppCompatActivity {

    TextView numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, ansOne, ansTwo, ansThree, ansFour, ansFive, ansSix;
    LinearLayout linerL0, linerL1, linerL2, linerL3, linerL4, linerL5, linerL6;
    Context mContext;
    ArrayList<TextView> textViewsArray = new ArrayList<>();
    int level, min, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BubbleActivity.this;
        setContentView(R.layout.activity_bubbly);
        AnimationIntent.backHome((ImageView) findViewById(R.id.imgHome), mContext);
        SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(mContext);
        level = pre.getInt("level",0);
        min = level * 4;
        max = min + 4;
        Log.d("Level", level + "");
        onLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = pre.edit();
        editor.putInt("level",0);
        editor.commit();
        Log.d("Resume", "onResume");
    }

    public void onLoad(){
        numOne = (TextView) findViewById(R.id.numOne);
        numTwo = (TextView) findViewById(R.id.numTwo);
        numThree = (TextView) findViewById(R.id.numThree);
        numFour = (TextView) findViewById(R.id.numFour);
        numFive = (TextView) findViewById(R.id.numFive);
        ansOne = (TextView) findViewById(R.id.ansOne);
        ansTwo = (TextView) findViewById(R.id.ansTwo);
        ansThree = (TextView) findViewById(R.id.ansThree);
        ansFour = (TextView) findViewById(R.id.ansFour);
        ansFive = (TextView) findViewById(R.id.ansFive);
        ansSix = (TextView) findViewById(R.id.ansSix);
        RandomNumbers();
        linerL0 = (LinearLayout) findViewById(R.id.linerL0);
        linerL1 = (LinearLayout) findViewById(R.id.linerL1);
        linerL2 = (LinearLayout) findViewById(R.id.linerL2);
        linerL3 = (LinearLayout) findViewById(R.id.linerL3);
        linerL4 = (LinearLayout) findViewById(R.id.linerL4);
        RandomNumbers();
        TextView[] textViews = {ansOne, ansTwo, ansThree, ansFour, ansFive, ansSix};
        FontStyle.onFontFutura(textViews, mContext);
        TextView[] textViews1 = {numOne, numTwo, numThree, numFour, numFive};
        DragAndDrop.setTouchListener(textViews1, mContext);
        LinearLayout[] linearLayouts = {linerL0, linerL1, linerL2, linerL3, linerL4};
        DragAndDrop.setEventDragBubbleListener(linearLayouts, mContext,textViews1, level);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.reFull);
        DragAndDrop.setEventDragOutListener(relativeLayout, mContext);
    }
    public void RandomNumbers(){
        Random random = new Random();
        int numberQuestion = RandomGenerator.nextIntInRange(2, 4, random);
        Log.d("numberQuestion", "" + numberQuestion);
        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList = RandomGenerator.randomNumberList(min, max);
        arrayList = RandomGenerator.randomNumberListBubble(min, max);
//        ArrayList<Integer> arrayListLocal = new ArrayList<>();
//        arrayListLocal = RandomGenerator.randomNumberLocal(min, max, numberQuestion);
        int loop = arrayList.size();
        for(int i = 0; i<loop; i++){
            switch (i){
                case 0:
                    numOne.setText(arrayList.get(i).toString());
                    setFontF(numOne);
                    break;
                case 1:
                    numTwo.setText(arrayList.get(i).toString());
                    setFontF(numTwo);
                    break;
                case 2:
                    numThree.setText(arrayList.get(i).toString());
                    setFontF(numThree);
                    break;
                case 3:
                    numFour.setText(arrayList.get(i).toString());
                    setFontF(numFour);
                    break;
                case 4:
                    numFive.setText(arrayList.get(i).toString());
                    setFontF(numFive);
                    break;
                default:
                    break;
            }
            ArrayList<Integer> arrayListAnswer = new ArrayList<>();
            arrayListAnswer = RandomGenerator.randomNumberAuto(min, min+6);
            Answer(arrayListAnswer);
        }
    }

    public void setFontF(TextView textView){
        TextView[] textViews = {textView};
        FontStyle.onFontFutura(textViews, mContext);
    }
    public void Answer(ArrayList<Integer> arrayList){
        ansOne.setText(arrayList.get(0).toString());
        ansTwo.setText(arrayList.get(1).toString());
        ansThree.setText(arrayList.get(2).toString());
        ansFour.setText(arrayList.get(3).toString());
        ansFive.setText(arrayList.get(4).toString());
        ansSix.setText(arrayList.get(5).toString());
    }
}
