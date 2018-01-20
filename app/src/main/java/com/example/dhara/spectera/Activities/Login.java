package com.example.dhara.spectera.Activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dhara.spectera.Dialogs.Aleartdialogs;
import com.example.dhara.spectera.Qrscanner.Qr_Scanner;
import com.example.dhara.spectera.R;
import com.example.dhara.spectera.interfaces.Finish;
import com.example.dhara.spectera.interfaces.Initializer;
import com.example.dhara.spectera.interfaces.QrScannerResult;

public class Login extends AppCompatActivity implements Initializer, QrScannerResult,Finish {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        initialize();
    }

    @Override
    public void initialize() {
        imageView = (ImageView) findViewById(R.id.imageview);
        Glide.with(this).load(R.drawable.image1).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

    public void login(View view){
        Intent intent=new Intent(this,Form.class);
        startActivity(intent);
    }
    @Override
    public void qrscannreresult(String s) {

    }

    @Override
    public void finishall() {
        finish();
    }

    @Override
    public void dialogYesCallBack() {

    }
}
