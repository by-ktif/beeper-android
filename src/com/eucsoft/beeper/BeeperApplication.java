package com.eucsoft.beeper;

import android.app.Application;
import android.content.Context;

public class BeeperApplication extends Application {
	
	private static Context context;

    public void onCreate(){
        super.onCreate();
        BeeperApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return BeeperApplication.context;
    }

}
