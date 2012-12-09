package com.eucsoft.beeper.http.test;

import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.http.DownloadMessageTask;
import com.eucsoft.beeper.http.SendMessageTask;

public class TestButtonListener implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		new SendMessageTask().execute();
		
		new DownloadMessageTask().execute("http://www.w3schools.com/html/horse.ogg");
	}
}
