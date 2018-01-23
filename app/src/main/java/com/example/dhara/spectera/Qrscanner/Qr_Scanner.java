package com.example.dhara.spectera.Qrscanner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by dhara on 12-01-2018.
 */

public class Qr_Scanner implements ZXingScannerView.ResultHandler {

    Context context;
    AppCompatActivity appCompatActivity;
    QrScannerResult qrScannerResult;
    ZXingScannerView zXingScannerView;
    public Qr_Scanner(Context context,QrScannerResult qrScannerResult) {
        this.context = context;
        this.qrScannerResult = qrScannerResult;
        appCompatActivity= (AppCompatActivity) context;
        zXingScannerView=new ZXingScannerView(context);
        zXingScannerView.setResultHandler(this);
    }

    public void scanQr(){
        appCompatActivity.setContentView(zXingScannerView);
        zXingScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        zXingScannerView.setResultHandler(this);
        zXingScannerView.stopCamera();
        qrScannerResult.qrscannreresult(result.getText().toString());
    }


    public static interface QrScannerResult {
        public void qrscannreresult(String s);
    }
}
