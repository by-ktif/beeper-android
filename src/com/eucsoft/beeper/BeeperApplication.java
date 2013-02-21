package com.eucsoft.beeper;

import java.net.Socket;

import android.R.string;
import android.app.Application;
import android.content.Context;

public class BeeperApplication extends Application {
	
	private static Context context;
	private static Socket clientSocket;

    public void onCreate(){
        super.onCreate();
        BeeperApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return BeeperApplication.context;
    }

	public static Socket getClientSocket() {
		return clientSocket;
	}

	public static void setClientSocket(Socket clientSocket) {
		BeeperApplication.clientSocket = clientSocket;
	}

}
