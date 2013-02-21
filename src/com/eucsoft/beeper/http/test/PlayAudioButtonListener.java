package com.eucsoft.beeper.http.test;

import android.view.View;
import android.view.View.OnClickListener;

import com.eucsoft.beeper.audio.AudioPlayThread;

public class PlayAudioButtonListener implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		AudioPlayThread playThread = new AudioPlayThread();
        playThread.start();
	}
}
