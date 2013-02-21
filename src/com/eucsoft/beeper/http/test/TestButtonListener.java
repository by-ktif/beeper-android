package com.eucsoft.beeper.http.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.BeeperApplication;
import com.eucsoft.beeper.MainActivity;
import com.eucsoft.beeper.application.ApplicationContext;
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
		DataOutputStream os = null;
		DataInputStream is = null;
		try {
			Socket clientSocket = new Socket("192.168.1.7",6789);
			is = new DataInputStream(clientSocket.getInputStream());
			os = new DataOutputStream(clientSocket.getOutputStream());
			InputStream inputStream= new FileInputStream(Environment.getExternalStorageDirectory() + "/audio553.3gp");
			byte buf[]=new byte[1024];
			int len;
			while((len=inputStream.read(buf))>0)
				os.write(buf, 0, len);
			os.flush();
			clientSocket.shutdownOutput();
			os.close();
			inputStream.close();
			//os.writeBytes("Privet!");
			os.flush();
			byte[]  responseLine = new byte[1000];
            is.read(responseLine);
            System.out.println("Server: " + new String(responseLine));
            BeeperApplication.setClientSocket(clientSocket);
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
