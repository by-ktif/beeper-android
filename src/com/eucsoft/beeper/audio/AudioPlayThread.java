package com.eucsoft.beeper.audio;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

import com.eucsoft.beeper.server.Server;

public class AudioPlayThread extends Thread {

	//private int iAudioBufferSize;
	AudioTrack audioTrack;

	public AudioPlayThread() {
		audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
				AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
				20000, AudioTrack.MODE_STREAM);
		/*int iSampleRate = AudioTrack
				.getNativeOutputSampleRate(AudioManager.STREAM_SYSTEM);
		iAudioBufferSize = AudioTrack.getMinBufferSize(iSampleRate,
				AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);*/
		// Reading data.

	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

		audioTrack.play();

		byte[] data = null;
		//int n = 0;
		while (!interrupted()) {
			data = Server.read();
			System.out.println(data);
			if (data != null)
				audioTrack.write(data, 0, data.length);
		}

	}

}
