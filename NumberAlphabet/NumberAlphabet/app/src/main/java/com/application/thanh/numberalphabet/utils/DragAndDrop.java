package com.application.thanh.numberalphabet.utils;

import android.app.*;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Thanh on 1/15/2016.
 */
public class DragAndDrop {
    public static void setTouchListener(TextView[] textViews, Context mContext){
        int loop = textViews.length;
        for(int i=0; i<loop; i++){
            DragAndDrop.onTouchListener(textViews[i], mContext);
        }
    }
    public static void onTouchListener(TextView img, Context mContext){
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    // TODO Auto-generated method stub
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadow = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadow, v, 0);
                    v.setVisibility(View.VISIBLE);
                    return true;
                } else {
                    return false;
                }

            }
        });
    }
    public static void setEventDragListener(LinearLayout[] linearLayouts, final Context mContext, final TextView[] textViews, final ArrayList<TextView> textViewArrayList, final int level){
        int loop = linearLayouts.length;

        class MyDragListener implements View.OnDragListener {
            int level1 = level;
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        View view = (View) event.getLocalState();

                        TextView imgDrag = (TextView) view;
                        String textDrag = imgDrag.getText().toString();
                        Log.d("Name text drag = ", imgDrag.getText() + "");

                        LinearLayout container = (LinearLayout) v;
                        Log.d("Linear parent = ", container + "");
                        int counts = container.getChildCount();
                        for (int i = 0; i < counts; i++) {
                            TextView imgDrop = (TextView) container.getChildAt(i);
                            imgDrop.setText(textDrag);
                            Log.d("Name text drop = ", imgDrop.getText() + "");
                        }
                        if(DragAndDrop.validate(textViews)){
                            if(DragAndDrop.checkFinish(textViews)){
                                Dialog.onShowWin(mContext);
                                SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(mContext);
                                SharedPreferences.Editor editor = pre.edit();
                                if(level1 > 2){
                                    level1 = 0;
                                }else{
                                    level1++;
                                }
                                editor.putInt("level", level1);
                                editor.commit();
                            }else{
                                Dialog.onShowlose(mContext, textViewArrayList);
                            }
                        }
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        View views = (View) event.getLocalState();
                        // views.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        for(int i=0; i<loop; i++){
            linearLayouts[i].setOnDragListener(new MyDragListener());
        }
    }
    public static void setEventDragOutListener(RelativeLayout relativeLayout, Context mContext){
        class MyDragListener implements View.OnDragListener {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        View view = (View) event.getLocalState();
                        TextView imgDrag = (TextView) view;
                        String tag = imgDrag.getTag().toString();
                        if(!tag.equals("0")){
                            imgDrag.setText("?");
                        }

                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        View views = (View) event.getLocalState();
                        // views.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        relativeLayout.setOnDragListener(new MyDragListener());

    }
    public static boolean validate( TextView[] textViews){
        int size = textViews.length;
        for(int i=0; i<size; i++ ){
            if(textViews[i].getText().toString().equals("?")){
                return false;
            }
        }
        return true;
    }
    public static boolean checkFinish(TextView[] textViews){
        int size = textViews.length;
        int k = 0;
        for(int i=0; i<textViews.length; i++){
            for(int j=0; j<i; j++){
                int small = Integer.parseInt(textViews[j].getText().toString());
                int pig = Integer.parseInt(textViews[i].getText().toString());
                if(small >= pig){
                    return false;
                }
            }
        }
        return true;
    }
    public static void setEventDragBubbleListener(LinearLayout[] linearLayouts, final Context mContext, final TextView[] textViews, final int level){
        int loop = linearLayouts.length;

        class MyDragListener implements View.OnDragListener {
            int level1 = level;
            @Override
            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:
                        View view = (View) event.getLocalState();
                        TextView imgDrag = (TextView) view;
                        String textDrag = imgDrag.getText().toString();
//                        Log.d("Name text drag = ", imgDrag.getText() + "");
                        LinearLayout container = (LinearLayout) v;
//                        Log.d("Linear parent = ", container + "");
                        int counts = container.getChildCount();
                        for (int i = 0; i < counts; i++) {
                            TextView imgDrop = (TextView) container.getChildAt(i);
                            String textDrop = imgDrop.getText().toString();
                            imgDrop.setText(textDrag);
                            imgDrag.setText(textDrop);
//                            imgDrag.setZ();
                            //ImageView img_animation = (ImageView) findViewById(R.id.img_animation);

                            TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
                                    0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
                            animation.setDuration(5000);  // animation duration
                            animation.setRepeatCount(5);  // animation repeat count
                            animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
                            //animation.setFillAfter(true);

                            ((LinearLayout)(imgDrag.getParent())).startAnimation(animation);

//                            imgDrag.startAnimation(animation);  // start animation
//

                            Log.d("Name text drop = ", imgDrop.getText() + "");
                        }
                        if(DragAndDrop.checkFinish(textViews)){
                            Dialog.onShowWin(mContext);
                            SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(mContext);
                            SharedPreferences.Editor editor = pre.edit();
                            if(level1 > 2){
                                level1 = 0;
                            }else{
                                level1++;
                            }
                            editor.putInt("level", level1);
                            editor.commit();
                        }else{
//                            Dialog.onShowlose(mContext, textViewArrayList);
                        }
//                        if(DragAndDrop.validate(textViews)){
//                            if(DragAndDrop.checkFinish(textViews)){
//                                Dialog.onShowWin(mContext);
//                                SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(mContext);
//                                SharedPreferences.Editor editor = pre.edit();
//                                if(level1 > 2){
//                                    level1 = 0;
//                                }else{
//                                    level1++;
//                                }
//                                editor.putInt("level", level1);
//                                editor.commit();
//                            }else{
//                                Dialog.onShowlose(mContext, textViewArrayList);
//                            }
//                        }
                        view.setVisibility(View.VISIBLE);
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        View views = (View) event.getLocalState();
                        // views.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        for(int i=0; i<loop; i++){
            linearLayouts[i].setOnDragListener(new MyDragListener());
        }
    }


}
