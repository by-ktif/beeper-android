package com.eucsoft.beeper.button.record;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.eucsoft.beeper.application.ApplicationContext;
import com.eucsoft.beeper.audio.AudioRecorder;
import com.eucsoft.beeper.audio.AudioRecorderThread;
import com.eucsoft.beeper.http.SendMessageTask;

public class RecordButtonListener implements OnTouchListener{
	
	//AudioRecorder recorder = new AudioRecorder();
	AudioRecorderThread recorderThread;
	
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
		recorderThread = new AudioRecorderThread();
        recorderThread.start();
	}
	
	private void onUp(View v) {
		v.setPressed(false);
		recorderThread.interrupt();
		
		Button recordButton = ((Button)v);
		recordButton.setText(recorderThread.getBytesReadCount()+"");
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
		//recordButton.setText(String.valueOf(++countPress));
	}
	
	
}