package com.example.dhara.spectera.NetWork;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dhara.spectera.Pojo.RequestData;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dhara on 22-01-2018.
 */

public class NetWorking {
    RequestQueue requestQueue;
    Context context;
    NetWorkCallBack netWorkCallBack;
    ProgressDialog progressDialog;

    public NetWorking(Context context, NetWorkCallBack netWorkCallBack) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
        this.netWorkCallBack = netWorkCallBack;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait");
    }

    public void SendRequest(String url, final Map<String, String> map) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                netWorkCallBack.netWorkCallBack(response, true);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                String message = "";
                if (error == null) {
                    message = "Please Check Your NetWork";
                } else {
                    message = error.toString();
                }
                netWorkCallBack.netWorkCallBack(message, false);
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map == null) {
                    return super.getParams();
                }else{
                    return map;
                }
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                headers.put("Content-Type", "application/json");
                return (headers != null || headers.isEmpty()) ? headers : super.getHeaders();
            }
        };
        progressDialog.show();
        requestQueue.add(request);
    }

    public interface NetWorkCallBack {
        public void netWorkCallBack(String s, boolean sucess);
    }
}
