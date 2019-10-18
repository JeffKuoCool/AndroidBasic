package com.ztlj.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

import com.ztlj.common.interfaces.NetworkStateListener;

/**
 * @date: 2019-10-12
 * @autror: guojian
 * @description:
 */
public class NetworkReceiver extends BroadcastReceiver {

    private NetworkStateListener networkStateListener;

    public NetworkReceiver(NetworkStateListener listener){
        this.networkStateListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                int type2 = networkInfo.getType();
                String typeName = networkInfo.getTypeName();

                switch (type2) {
                    case 0://移动 网络    2G 3G 4G 都是一样的 实测 mix2s 联通卡
                        mobile();
                        break;
                    case 1: //wifi网络
                        wifi();
                        break;
                }
            } else {// 无网络
                none();
            }
        }
    }

    public void register(Context context){
        IntentFilter timeFilter = new IntentFilter();
        timeFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
        timeFilter.addAction("android.net.ethernet.STATE_CHANGE");
        timeFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        timeFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        timeFilter.addAction("android.net.wifi.STATE_CHANGE");
        timeFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        context.registerReceiver(this, timeFilter);
    }

    private void mobile(){
        if(networkStateListener!=null){
            networkStateListener.mobile();
        }
    }

    private void wifi(){
        if(networkStateListener!=null){
            networkStateListener.wifi();
        }
    }

    private void none(){
        if(networkStateListener!=null){
            networkStateListener.none();
        }
    }
}
