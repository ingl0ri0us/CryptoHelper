package com.example.cryptohelper.ui;

import android.app.Application;

import com.example.cryptohelper.BuildConfig;

import butterknife.ButterKnife;
import timber.log.Timber;

public class ApplicationController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(true);
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
