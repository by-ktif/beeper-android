package com.eucsoft.beeper.audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.eucsoft.beeper.file.FileUtil;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;

public class AudioPlayThread extends Thread {

	private int iAudioBufferSize;
	AudioTrack audioTrack;

	public AudioPlayThread() {
		audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
				AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
				20000, AudioTrack.MODE_STREAM);
		int iSampleRate = AudioTrack
				.getNativeOutputSampleRate(AudioManager.STREAM_SYSTEM);
		iAudioBufferSize = AudioTrack.getMinBufferSize(iSampleRate,
				AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
		// Reading data.

	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		audioTrack.play();
		
		File beeperDir = FileUtil.getBeeperFolder();
		String uniqFilePath = beeperDir.getAbsolutePath() + "/" + "beeper.rec";

		File file = new File(uniqFilePath);

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);

			byte[] data = new byte[1000];
			int n = 0;
			while ((n = fis.read(data)) != -1)
				audioTrack.write(data, 0, n);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
