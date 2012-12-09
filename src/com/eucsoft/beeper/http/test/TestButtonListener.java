package com.eucsoft.beeper.http.test;

import java.io.File;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.http.DownloadMessageTask;
import com.eucsoft.beeper.http.SendMessageTask;

public class TestButtonListener implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		new DownloadMessageTask().execute("http://www.w3schools.com/html/horse.ogg");
		
		File message = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/horse.ogg");
		new SendMessageTask().execute(message.getAbsolutePath(),"1","1");
	}
}
