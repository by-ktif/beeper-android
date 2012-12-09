package com.eucsoft.beeper.button.record;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.eucsoft.beeper.audio.AudioRecorder;
import com.eucsoft.beeper.http.SendMessageTask;

public class RecordButtonListener implements OnTouchListener{
	
	AudioRecorder recorder;
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction() ) {
	    	case MotionEvent.ACTION_DOWN:
	    		v.setPressed(true);
	    		Button b = ((Button)v);
	    		String text = b.getText().toString();
	    		int i = 0;
	    		try {
	    			i = Integer.parseInt(text);
	    		} catch(Exception e) {
	    			i = 0;
	    		}
	    		b.setText(String.valueOf(++i));
	    		recorder = new AudioRecorder();
	    		recorder.startRecording();
	    		break;
	    	case MotionEvent.ACTION_UP:
	    		v.setPressed(false);
	    		String filePath = recorder.stopRecording();
	    		new SendMessageTask().execute(filePath,"1","1");
	    		break;
	    }
	    return true;
	}	
}