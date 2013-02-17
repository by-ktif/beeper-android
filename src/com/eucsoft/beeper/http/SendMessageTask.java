package com.eucsoft.beeper.http;

import java.io.File;

import android.os.AsyncTask;

import com.eucsoft.beeper.file.FileUtil;

public class SendMessageTask extends AsyncTask<String, Void, File> {

	@Override
	protected File doInBackground(String... params) {
		String filePath = params[0];
		File file = new File(filePath);
		String userId = params[1];
		String clientId = params[2];

		return file;
	}

	@Override
	protected void onPostExecute(File file) {
		super.onPostExecute(file);
		
		FileUtil.deleteFile(file);
	}

}
