package com.eucsoft.beeper.http.test;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

public class PlayAudioButtonListener implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		MediaPlayer mp = MediaPlayer.create(arg0.getContext(), Uri.parse("http://192.168.1.101:8080/files/TTGG2113402992.3gp"));
		mp.start();
	}
}
