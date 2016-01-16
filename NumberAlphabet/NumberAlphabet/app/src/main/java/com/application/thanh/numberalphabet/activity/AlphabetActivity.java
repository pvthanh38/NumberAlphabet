package com.application.thanh.numberalphabet.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.thanh.numberalphabet.R;
import com.application.thanh.numberalphabet.utils.AnimationIntent;
import com.application.thanh.numberalphabet.utils.FontStyle;
import com.application.thanh.numberalphabet.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Random;

public class AlphabetActivity extends AppCompatActivity {

    TextView numOne, numTwo, numThree, numFour, numFive, numSix, numSeven, ansOne, ansTwo, ansThree, ansFour, ansFive, ansSix;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = AlphabetActivity.this;
        setContentView(R.layout.activity_alphabet);
        AnimationIntent.backHome((ImageView) findViewById(R.id.imgHome), mContext);
        onLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume", "onResume");
    }

    public void onLoad(){
        numOne = (TextView) findViewById(R.id.numOne);
        numTwo = (TextView) findViewById(R.id.numTwo);
        numThree = (TextView) findViewById(R.id.numThree);
        numFour = (TextView) findViewById(R.id.numFour);
        numFive = (TextView) findViewById(R.id.numFive);
        numSix = (TextView) findViewById(R.id.numSix);
        numSeven = (TextView) findViewById(R.id.numSeven);
        ansOne = (TextView) findViewById(R.id.ansOne);
        ansTwo = (TextView) findViewById(R.id.ansTwo);
        ansThree = (TextView) findViewById(R.id.ansThree);
        ansFour = (TextView) findViewById(R.id.ansFour);
        ansFive = (TextView) findViewById(R.id.ansFive);
        ansSix = (TextView) findViewById(R.id.ansSix);
        RandomNumbers();
        TextView[] textViews = {ansOne, ansTwo, ansThree, ansFour, ansFive, ansSix};
        FontStyle.onFontFutura(textViews, mContext);

    }
    public void RandomNumbers(){
        Random random = new Random();
        int numberQuestion = RandomGenerator.nextIntInRange(2, 4, random);
        Log.d("numberQuestion","" + numberQuestion);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = RandomGenerator.randomNumberAuto(0, 6);
        ArrayList<Integer> arrayListLocal = new ArrayList<>();
        arrayListLocal = RandomGenerator.randomNumberLocal(0, 6, numberQuestion);
        int loop = arrayList.size();
        for(int i = 0; i<loop; i++){
            if(arrayListLocal.contains(arrayList.get(i))){
                Log.d("ArrayList","?");

                switch (i){
                    case 0:
                        numOne.setText("?");
                        setFont(numOne);
                        break;
                    case 1:
                        numTwo.setText("?");
                        setFont(numTwo);
                        break;
                    case 2:
                        numThree.setText("?");
                        setFont(numThree);
                        break;
                    case 3:
                        numFour.setText("?");
                        setFont(numFour);
                        break;
                    case 4:
                        numFive.setText("?");
                        setFont(numFive);
                        break;
                    case 5:
                        numSix.setText("?");
                        setFont(numSix);
                        break;
                    case 6:
                        numSeven.setText("?");
                        setFont(numSeven);
                        break;
                    default:
                        break;
                }
            }else{
                Log.d("ArrayList",""+arrayList.get(i));
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
                    case 5:
                        numSix.setText(arrayList.get(i).toString());
                        setFontF(numSix);
                        break;
                    case 6:
                        numSeven.setText(arrayList.get(i).toString());
                        setFontF(numSeven);
                        break;
                    default:
                        break;
                }
            }
            ArrayList<Integer> arrayListAnswer = new ArrayList<>();
            arrayListAnswer = RandomGenerator.randomNumberAnswer(0, 6, arrayListLocal);
            Answer(arrayListAnswer);
        }
    }
    public void setFont(TextView textView){
        textView.setTextSize(50);
        textView.setTextColor(getResources().getColor(R.color.colorOran));
        TextView[] textQuestion = {textView};
        FontStyle.onFontRegular(textQuestion, mContext);
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
