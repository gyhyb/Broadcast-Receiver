package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager ConnectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = ConnectivityManager.getActiveNetworkInfo();
        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        if(activeNetwork != null && activeNetwork.isAvailable()){
            if(isWiFi){
                Log.i("NetWorkChangeReceiver","Wi-Fi类型");
            }
            else{
                Log.i("NetWorkChangeReceiver","其他网络类型");
            }
        }
        else {
            Log.i("NetworkChangeReceiver","连接断开");
        }
    }
}