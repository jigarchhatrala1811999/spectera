package com.example.dhara.spectera.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dhara.spectera.Dialogs.Aleartdialogs;
import com.example.dhara.spectera.R;
import com.example.dhara.spectera.interfaces.Finish;
import com.example.dhara.spectera.interfaces.Initializer;
import com.example.dhara.spectera.interfaces.QrScannerResult;

public class Qr_Scanner extends AppCompatActivity implements Initializer,QrScannerResult,Finish{

    com.example.dhara.spectera.Qrscanner.Qr_Scanner qr_scanner;
    Aleartdialogs aleartdialogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr__scanner);
        initialize();
    }

    @Override
    public void initialize() {
        aleartdialogs=new Aleartdialogs(this,this);
        qr_scanner=new com.example.dhara.spectera.Qrscanner.Qr_Scanner(this,this);
        qr_scanner.scanQr();
    }

    @Override
    public void qrscannreresult(String s) {
        aleartdialogs.showDialog(s);
    }

    @Override
    public void finishall() {
        finish();
    }

    @Override
    public void dialogYesCallBack() {
        qr_scanner.scanQr();
    }
}
