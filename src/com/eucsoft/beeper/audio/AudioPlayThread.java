package com.eucsoft.beeper.audio;

import java.io.IOException;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;

public class AudioPlayThread extends Thread {
	
	private int iAudioBufferSize;
	AudioTrack audioTrack;
	public AudioPlayThread() {
		audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, 20000, AudioTrack.MODE_STREAM);
		audioTrack.play();
		int iSampleRate = AudioTrack.getNativeOutputSampleRate(AudioManager.STREAM_SYSTEM);
		iAudioBufferSize = AudioTrack.getMinBufferSize(iSampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
		// Reading data.
	
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		byte[] data = new byte[iAudioBufferSize];
		int n = 0;
		try {
		  while ((n = s.getInputStream().read(data)) != -1)
		      audioTrack.write(data, 0, n);
		}
		catch (IOException e) {
		   return;
		}
	}

}
