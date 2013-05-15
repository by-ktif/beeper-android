package com.eucsoft.beeper.http.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.BeeperApplication;

public class TestButtonListener implements OnClickListener {
	
	static List<BasicNameValuePair> extraHeaders = Arrays.asList(
		    new BasicNameValuePair("Cookie", "session=abcd"));
		
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
