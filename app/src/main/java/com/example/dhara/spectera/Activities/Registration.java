package com.example.dhara.spectera.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhara.spectera.R;
import com.example.dhara.spectera.interfaces.Initializer;

public class Registration extends AppCompatActivity implements Initializer {

    TextView textView;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    public void initialize() {
        String stringss="Uid";
        textView= (TextView) findViewById(R.id.qrscannertext);
        linearLayout= (LinearLayout) findViewById(R.id.registrationlinearlayout);
        for(int i=1;i<=8;i++){
            View view= LayoutInflater.from(this).inflate(R.layout.mylayouts,null,false);
            LinearLayout linearLayout1= (LinearLayout) view.findViewById(R.id.firstlinearout);
            TextView textView= (TextView) view.findViewById(R.id.firstuidtext);
            textView.setText(stringss+i);
        }
    }
}
