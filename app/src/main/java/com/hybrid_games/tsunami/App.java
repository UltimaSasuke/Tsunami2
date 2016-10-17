package com.hybrid_games.tsunami;

import android.content.Context;

/**
 * Created by Diego on 15/06/2016.
 */
public class App extends android.app.Application
{
    private static App mApp = null;
    /* (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        mApp = this;
    }
    public static Context context()
    {
        return mApp.getApplicationContext();
    }
}