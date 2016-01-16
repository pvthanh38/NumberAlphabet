package com.application.thanh.numberalphabet.utils;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.application.thanh.numberalphabet.R;
import com.application.thanh.numberalphabet.activity.NumberActivity;

import java.util.ArrayList;

/**
 * Created by Thanh on 1/15/2016.
 */
public class Dialog {
    public static void onShowWin(final Context mContext){
        android.app.Dialog dialog = new android.app.Dialog(mContext);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_congratulation);
        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                ((Activity) mContext).finish();
                ((Activity) mContext).startActivity(((Activity) mContext).getIntent());
                ((Activity) mContext).overridePendingTransition(R.anim.left, R.anim.right);
            }
        });
    }
    public static void onShowlose(Context mContext, final ArrayList<TextView> textViewArrayList){
        android.app.Dialog dialog = new android.app.Dialog(mContext);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_try_again);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                int size = textViewArrayList.size();
                for (int i = 0; i < size; i++) {
                    textViewArrayList.get(i).setText("?");
                }
            }
        });
        dialog.show();
    }
}
