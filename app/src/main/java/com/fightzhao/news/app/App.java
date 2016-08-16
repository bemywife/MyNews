package com.fightzhao.news.app;

import android.app.Application;
import android.content.Context;

/**
 * fightzhao on 16/8/12.
 * Function : App
 */
public class App extends Application {
    private static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return sApplicationContext;
    }

}
