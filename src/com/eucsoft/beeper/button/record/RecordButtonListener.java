package com.eucsoft.beeper.button.record;

import com.eucsoft.beeper.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RecordButtonListener implements OnClickListener {

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
		//b.setBackgroundResource(R.drawable.record_button_pressed);
	}
	
	

}
