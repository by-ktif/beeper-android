package com.eucsoft.beeper.audio;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder.AudioSource;
import android.widget.Button;

import com.eucsoft.beeper.file.FileUtil;

public class AudioRecorderThread extends Thread {

	private BufferedOutputStream bos;
	private AudioRecord recorder;
	private int iAudioBufferSize;
	private int bytesReadCount;
	Button recordButton;

	public AudioRecorderThread() {
		int iSampleRate = AudioTrack.getNativeOutputSampleRate(AudioManager.STREAM_SYSTEM);
		iAudioBufferSize = AudioRecord.getMinBufferSize(iSampleRate, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT); 
	    recorder = new AudioRecord(AudioSource.MIC, iSampleRate, AudioFormat.CHANNEL_IN_MONO, 
	        AudioFormat.ENCODING_PCM_16BIT, iAudioBufferSize);
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		recorder.startRecording();
		byte[] buffer = new byte[iAudioBufferSize];
		int iBufferReadResult;
		bytesReadCount = 0;
		
		File file = new File(FileUtil.getUniqFilePath());
		 
		// if file doesnt exists, then create it
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		BufferedWriter bw = new BufferedWriter(fw);
		
		while (!interrupted()) {
			iBufferReadResult = recorder.read(buffer, 0, iAudioBufferSize);
			// Android is reading less number of bytes than requested.
			if (iAudioBufferSize > iBufferReadResult) {
				iBufferReadResult = iBufferReadResult
						+ recorder.read(buffer, iBufferReadResult - 1,
								iAudioBufferSize - iBufferReadResult);
			}
			bytesReadCount = bytesReadCount + iBufferReadResult;
			for (int i = 0; i < iBufferReadResult; i++) {
				/*try {
					bos.write(buffer[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}*/
			}
		}
		 recorder.stop();
		 //recordButton.setText(""+bytesReadCount);
	}

	public int getBytesReadCount() {
		return bytesReadCount;
	}

}
