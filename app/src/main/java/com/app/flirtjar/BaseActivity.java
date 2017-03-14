package com.app.flirtjar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by rutvik on 3/3/2017 at 11:49 PM.
 */

public abstract class BaseActivity extends AppCompatActivity
{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_navLogoText)
    TextView tvNavLogoText;

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

        ButterKnife.bind(this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Righteous-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        final Typeface pacifico = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");

        tvNavLogoText.setTypeface(pacifico);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("");

        registerReceiver(mNetworkDetectReceiver,
                new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
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
