package com.example.dhara.spectera.Dialogs;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhara.spectera.R;
/**
 * Created by dhara on 22-01-2018.
 */
public class RegistrationDialog {
    Context context;
    Dialog dialog;
    Button submit,cancle;
    EditText edittext;
    RegistrationCallBack registrationCallBack;
    public RegistrationDialog(Context context,RegistrationCallBack registrationCallBack) {
        this.context = context;
        dialog=new Dialog(context);
        this.registrationCallBack=registrationCallBack;
        dialog.setContentView(R.layout.registrationdialog);
        submit= (Button) dialog.findViewById(R.id.regdialog_submit);
        cancle= (Button) dialog.findViewById(R.id.regdialog_cancle);
        edittext= (EditText) dialog.findViewById(R.id.dialog_userEdit);
        dialog.setTitle("User Info");
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        setclicklistners();
    }

    private void setclicklistners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid=edittext.getText().toString();
                if(uid.isEmpty()){
                    edittext.setError("User Id");
                    return;
                }
                dialog.dismiss();
                edittext.setText("");
                registrationCallBack.dialogresult(uid);

            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void showDialog(){
        dialog.show();
    }

    public interface RegistrationCallBack{
        public void dialogresult(String s);
    };
}
