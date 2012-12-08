package com.eucsoft.beeper.audio;

import java.io.IOException;

import android.media.MediaRecorder;

public class AudioRecorder {

	private MediaRecorder recorder;

	public void startRecording() {
		
		
		
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		
		recorder.setOutputFile("test");
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try {
			recorder.prepare();
		} catch (IOException e) {
		}

		recorder.start();
	}

	public void stopRecording() {
		recorder.stop();
		recorder.release();
		recorder = null;
	}

}
