package com.eucsoft.beeper.button.record;

import com.eucsoft.beeper.audio.AudioRecord;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RecordButtonListener implements OnClickListener {
	
	private static AudioRecord recorder = null;

	@Override
	public void onClick(View v) {
		Button b = ((Button)v);
		String text = b.getText().toString();
		int i = 0;
		try {
			i = Integer.parseInt(text);
		} catch(Exception e) {
			i = 0;
		}
		b.setText(String.valueOf(++i));
		
		if (recorder == null) {
			recorder = new AudioRecord();
			recorder.startRecording();
		} else {
			recorder.stopRecording();
			recorder = null;
		}
	}
	
}