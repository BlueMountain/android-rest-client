package com.dg.examples.restclientdemo.app;

import android.app.Application;

import com.dg.libs.android.logger.ALog;
import com.dg.libs.android.logger.ALog.DebugLevel;
import com.dg.libs.rest.authentication.TokenAuthenticationProvider;

public class App extends Application {

    public static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        TokenAuthenticationProvider.init(this);
        ALog.setDebugLevel(DebugLevel.ALL);
    }
}
