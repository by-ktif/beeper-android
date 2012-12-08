package com.eucsoft.beeper.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Environment;

public class DownloadFileTask extends AsyncTask<String, Integer, File>{

    @Override
    protected File doInBackground(String... uri) {
    	String messageListUrl = uri[0];
    	
        try {
        	HttpClient httpclient = new DefaultHttpClient();
        	
        	HttpResponse response = httpclient.execute(new HttpGet(messageListUrl));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);

                File messagesDir = new File(Environment.getExternalStorageDirectory() + "/messages");
                if (!messagesDir.exists()) {
                	messagesDir.mkdir();
                }
                
                String messagePath = messagesDir.getAbsolutePath() + "/test.mp3";
                File message = new File(messagePath);
            	message.deleteOnExit();
            	
                FileOutputStream fos = new FileOutputStream(message);

                out.writeTo(fos);
                out.close();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return new File("");
    }

    @Override
    protected void onPostExecute(File result) {
        super.onPostExecute(result);
        //Do anything with response..
    }
}