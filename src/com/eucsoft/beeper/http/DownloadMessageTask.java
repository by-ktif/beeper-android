package com.eucsoft.beeper.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

import com.eucsoft.beeper.file.FileUtil;

public class DownloadMessageTask extends AsyncTask<String, Integer, File>{

    @Override
    protected File doInBackground(String... uri) {
    	File result = null;
    	String messageListUrl = uri[0];
    	
        try {
        	HttpClient httpclient = new DefaultHttpClient();
        	
        	HttpResponse response = httpclient.execute(new HttpGet(messageListUrl));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);

                String messagePath = FileUtil.getUniqFilePath();
                File message = new File(messagePath);
                FileOutputStream fileOutput = new FileOutputStream(message);

                out.writeTo(fileOutput);
                out.close();

                result = message;
            } else {
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        //Do anything with response..
    }
}