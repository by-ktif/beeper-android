package com.eucsoft.beeper.audio;

import java.io.IOException;

import android.media.MediaRecorder;
import android.os.ParcelFileDescriptor;

import com.eucsoft.beeper.BeeperApplication;

public class AudioRecorder {

	private MediaRecorder recorder = new MediaRecorder();

	public void startRecording() {
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		final ParcelFileDescriptor pfd = ParcelFileDescriptor.fromSocket(BeeperApplication.getClientSocket());
		recorder.setOutputFile(pfd.getFileDescriptor());	
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
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
		try {
			BeeperApplication.getClientSocket().shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
