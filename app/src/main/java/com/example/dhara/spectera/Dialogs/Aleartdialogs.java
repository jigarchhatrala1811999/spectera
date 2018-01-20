package com.example.dhara.spectera.Dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.dhara.spectera.interfaces.Finish;

/**
 * Created by dhara on 17-01-2018.
 */

public class Aleartdialogs {
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    Context context;
    Finish finish;
    public Aleartdialogs(final Context context, final Finish finish) {
        this.context = context;
        this.finish=finish;
        builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish.dialogYesCallBack();
            }
        });
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
                finish.finishall();
            }
        });
    }

    public void showDialog(String message){
        builder.setTitle("Aleart Dialog");
        builder.setMessage(message);
        alertDialog=builder.create();
        alertDialog.show();
    }
}
