package com.application.thanh.numberalphabet.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Thanh on 1/14/2016.
 */
public class FontStyle {
    public static void onFontFutura( TextView[] textViews, Context mcontext){
        Typeface fontText = Typeface.createFromAsset(mcontext.getAssets(),"fonts/Futura_Extra_Bold.ttf");
        for(int i = 0; i<textViews.length; i++){
            textViews[i].setTypeface(fontText);
        }
    }
    public static void onFontRegular( TextView[] textViews, Context mcontext){
        Typeface fontText = Typeface.createFromAsset(mcontext.getAssets(),"fonts/Regular.ttf");
        for(int i = 0; i<textViews.length; i++){
            textViews[i].setTypeface(fontText);
        }
    }
}
