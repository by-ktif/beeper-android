package com.eucsoft.beeper.http.test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.MainActivity;
import com.eucsoft.beeper.application.ApplicationContext;
import com.eucsoft.beeper.http.DownloadMessageTask;
import com.eucsoft.beeper.wesocket.WebSocketClient;

public class TestButtonListener implements OnClickListener {
	
	static List<BasicNameValuePair> extraHeaders = Arrays.asList(
		    new BasicNameValuePair("Cookie", "session=abcd"));

		public static WebSocketClient client = new WebSocketClient(URI.create(ApplicationContext.websocketUrl), new WebSocketClient.Handler() {
		    @Override
		    public void onConnect() {
		        Log.d("BLA", "Connected!");
		    }

		    @Override
		    public void onMessage(String message) {
		    	MediaPlayer mp = MediaPlayer.create(MainActivity.context, Uri.parse(message));
				mp.start();
		        Log.d("BLA", String.format("Got string message! %s", message));
		    }

		    @Override
		    public void onMessage(byte[] data) {
		        //Log.d("BLA", String.format("Got binary message! %s", toHexString(data)));
		    }

		    @Override
		    public void onDisconnect(int code, String reason) {
		        Log.d("BLA", String.format("Disconnected! Code: %d Reason: %s", code, reason));
		    }

		    @Override
		    public void onError(Exception error) {
		        Log.e("BLA", "Error!", error);
		    }
		}, extraHeaders);
		
				

	@Override
	public void onClick(View arg0) {
		new DownloadMessageTask().execute("http://www.w3schools.com/html/horse.ogg");
		client.connect();
	}
}
