package com.eucsoft.beeper.button.record;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.eucsoft.beeper.application.ApplicationContext;
import com.eucsoft.beeper.audio.AudioRecorder;
import com.eucsoft.beeper.http.SendMessageTask;

public class RecordButtonListener implements OnTouchListener{
	
	AudioRecorder recorder;
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction() ) {
	    	case MotionEvent.ACTION_DOWN:
	    		onDown(v);
	    		addNumberToButton(v);
	    		break;
	    	case MotionEvent.ACTION_UP:
	    		onUp(v);
	    		break;
	    }
	    return true;
	}
	
	private void onDown(View v) {
		v.setPressed(true);
		
		recorder = new AudioRecorder();
		recorder.startRecording();
	}
	
	private void onUp(View v) {
		v.setPressed(false);
		String filePath = recorder.stopRecording();
		new SendMessageTask().execute(filePath, ApplicationContext.userId, ApplicationContext.channelId);
	}
	
	private void addNumberToButton(View v) {
		Button recordButton = ((Button)v);
		String text = recordButton.getText().toString();
		int countPress = 0;
		try {
			countPress = Integer.parseInt(text);
		} catch(Exception e) {
			countPress = 0;
		}
		recordButton.setText(String.valueOf(++countPress));
	}
	
	
}