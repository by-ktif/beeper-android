package com.eucsoft.beeper.audio;

import java.io.IOException;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

public class AudioPlayThread extends Thread {

	
	public AudioPlayThread() {
		AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, 20000, AudioTrack.MODE_STREAM);
		audioTrack.play();
		// Reading data.
		byte[] data = new byte[200];
		int n = 0;
		/*try {
		  while ((n = s.getInputStream().read(data)) != -1)
		      audioTrack.write(data, 0, n);
		}
		catch (IOException e) {
		   return;
		}*/
		
		
	}

	@Override
	public void run() {

		super.run();
	}

}
