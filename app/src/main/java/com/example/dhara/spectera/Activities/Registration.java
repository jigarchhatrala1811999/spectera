package com.example.dhara.spectera.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhara.spectera.Dialogs.RegistrationDialog;
import com.example.dhara.spectera.R;
import com.example.dhara.spectera.interfaces.Initializer;

import java.util.ArrayList;
import java.util.List;

public class Registration extends AppCompatActivity implements Initializer, RegistrationDialog.RegistrationCallBack {

    TextView textView;
    LinearLayout linearLayout;
    Bundle bundle;
    String data;
    int counter = 0;
    ListView listView;
    String udi = "Uid";
    RegistrationDialog dialog;
    List<String> userids = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initialize();
    }

    @Override
    public void initialize() {
        bundle = getIntent().getExtras();
        data = bundle.getString("data");
        dialog = new RegistrationDialog(this, this);
        textView = (TextView) findViewById(R.id.useridtxt);
        textView.append(data);
        listView = (ListView) findViewById(R.id.registration_user_list);
        /*String stringss = "Uid";
        textView = (TextView) findViewById(R.id.qrscannertext);
        textView.setText("Qr Scanner Id : " + data);
        linearLayout = (LinearLayout) findViewById(R.id.registrationlinearlayout);
        for (int i = 1; i <= 8; i++) {
            View view=LayoutInflater.from(this).inflate(R.layout.mylayouts,null,false);
            TextView textView= (TextView) view.findViewById(R.id.firstuidtext);
            textView.setText(stringss+i);
            linearLayout.addView(view);
        }*/
    }

    @Override
    public void dialogresult(String s) {
        counter++;
        userids.add(udi + counter + " : " + s);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, userids);
        listView.setAdapter(arrayAdapter);
    }

    public void adduserid(View view) {
        dialog.showDialog();
    }
}
