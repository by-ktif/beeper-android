package com.eucsoft.beeper.http;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.eucsoft.beeper.file.FileUtil;

import android.os.AsyncTask;

public class SendMessageTask extends AsyncTask<NameValuePair, Void, File> {

	@Override
	protected File doInBackground(NameValuePair... params) {
		// Create a new HttpClient and Post Header
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://beeper.com:8087/upload.do");

		try {
			// Add your data
			List<NameValuePair> nameValuePairs = Arrays.asList(params);
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			HttpResponse response = httpClient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			System.out.println(status.getStatusCode());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(File file) {
		super.onPostExecute(file);
		
		FileUtil.deleteFile(file);
	}

}
