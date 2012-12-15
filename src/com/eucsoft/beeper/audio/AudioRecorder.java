package com.eucsoft.beeper.audio;

import java.io.IOException;

import android.media.MediaRecorder;

import com.eucsoft.beeper.file.FileUtil;

public class AudioRecorder {

	private MediaRecorder recorder;
	private String filePath;

	public void startRecording() {
		recorder = new MediaRecorder();
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			
		filePath = FileUtil.getUniqFilePath();
		
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

	public String stopRecording() {
		recorder.stop();
		recorder.release();
		recorder = null;
		return filePath;
	}

}
