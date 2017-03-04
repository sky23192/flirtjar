package com.app.flirtjar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rutvik on 3/3/2017 at 11:49 PM.
 */

public abstract class BaseActivity extends AppCompatActivity
{

    private BroadcastReceiver mNetworkDetectReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            checkInternetConnection();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        registerReceiver(mNetworkDetectReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    protected abstract int getLayoutResourceId();


    private void checkInternetConnection()
    {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();

        if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED)
        {

        } else
        {
            showNoInternetView();
        }
    }

    protected abstract void showNoInternetView();

    @Override
    protected void onDestroy()
    {
        unregisterReceiver(mNetworkDetectReceiver);
        super.onDestroy();
    }
}
