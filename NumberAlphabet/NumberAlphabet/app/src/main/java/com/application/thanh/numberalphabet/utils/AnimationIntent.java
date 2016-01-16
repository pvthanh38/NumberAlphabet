package com.application.thanh.numberalphabet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.application.thanh.numberalphabet.R;
import com.application.thanh.numberalphabet.activity.MainActivity;


/**
 * Created by Thanh on 1/14/2016.
 */
public class AnimationIntent {
    ImageView img;
    public static void backHome(ImageView img, final Context mContext){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                ((Activity) mContext).startActivity(intent);
                ((Activity) mContext).overridePendingTransition(R.anim.back_left, R.anim.back_right);
            }
        });
    }
    public static void BackPage(ImageView img, final Context mcontext){

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
//                        view.setImageResource(R.drawable.back_select);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        ImageView view = (ImageView) v;
//                        view.setImageResource(R.drawable.back_select);
                        view.invalidate();
                        Activity activity = (Activity) mcontext;
                        activity.finish();
                        ((Activity) mcontext).overridePendingTransition(R.anim.back_left, R.anim.back_right);
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
//                        view.setImageResource(R.drawable.back);
                        view.invalidate();
                        break;
                    }
                }
                return true;
            }
        });
    }
}
