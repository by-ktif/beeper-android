package com.eucsoft.beeper.audio;

import java.io.File;
import java.io.IOException;

import android.media.MediaRecorder;

public class AudioRecorder {

	private MediaRecorder recorder;

	public void startRecording() {
		
		
		
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		
		File recordDir = new File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/record");
		if (!recordDir.exists()) {
			recordDir.mkdir();
		}
		
		String filePath = recordDir.getAbsolutePath();
		filePath += "/rec.3gp";
		
		
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setOutputFile(filePath);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try {
			recorder.prepare();
		} catch (IOException e) {
			e.printStackTrace();
		}

		recorder.start();
	}

	public void stopRecording() {
		recorder.stop();
		recorder.release();
		recorder = null;
	}

}
