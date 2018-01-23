package com.example.dhara.spectera.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dhara.spectera.Database.Main_DataBase;
import com.example.dhara.spectera.NetWork.NetWork2;
import com.example.dhara.spectera.NetWork.NetWorking;
import com.example.dhara.spectera.R;
import com.example.dhara.spectera.interfaces.Initializer;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements Initializer, NetWorking.NetWorkCallBack {

    Main_DataBase main_dataBase;
    ImageView imageView;
    EditText username, password;
    Spinner spinner;
    String[] logintypes;
    ArrayAdapter arrayAdapter;
    SharedPreferences sharedPreferences;
    NetWorking netWorking;
    public static String mainurl="http://accit.in";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,Manifest.permission.INTERNET}, 1);
        sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        if(!username.isEmpty()){
            Intent intent = new Intent(this, Form.class);
            startActivity(intent);
        }
        initialize();
    }

    @Override
    public void initialize() {
        main_dataBase=new Main_DataBase(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        spinner = (Spinner) findViewById(R.id.loginspinner);
        imageView = (ImageView) findViewById(R.id.imageview);
        netWorking = new NetWorking(this, this);
        logintypes = getResources().getStringArray(R.array.users);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, logintypes);
        spinner.setAdapter(arrayAdapter);
        Glide.with(this).load(R.drawable.image1).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

    public void login(View view) {
        boolean flag = true;
        String username, password, logintype;
        username = this.username.getText().toString();
        password = this.password.getText().toString();
        logintype = logintypes[spinner.getSelectedItemPosition()];
        if (username.isEmpty()) {
            flag = false;
        } else if (password.isEmpty()) {
            flag = false;
        }
        //Toast.makeText(this, username+"\n"+password, Toast.LENGTH_SHORT).show();
        if(!flag){
            Toast.makeText(this, "Please Enter Valid Data", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("logintype", logintype);
        String url=mainurl+"/public_html/android/login.php";
        //netWorking.SendRequest(url, map);
        //netWorking.SendRequest("http://accit.in/android/login.php", map);
        NetWork2.send("http://accit.in/android/login.php",map,this);
       /* sharedPreferences.edit().putString("username", username).apply();
        sharedPreferences.edit().putString("password", password).apply();
        sharedPreferences.edit().putString("logintype", logintype).apply();*/
    }

    @Override
    public void netWorkCallBack(String s, boolean sucess) {
        if (sucess) {
            if (!s.equals("yes")) {
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                //Snackbar.make(null, "Invalid Username And Password ", Snackbar.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, Form.class);
            startActivity(intent);
        } else {
            sharedPreferences.edit().putString("username", "").apply();
            sharedPreferences.edit().putString("password", "").apply();
            sharedPreferences.edit().putString("logintype", "").apply();
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            //Snackbar.make(null,"Check Your Internet Connection",Snackbar.LENGTH_LONG).show();
        }
    }
}
