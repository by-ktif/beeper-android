package com.eucsoft.beeper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;

import com.eucsoft.beeper.audio.AudioPlayThread;
import com.eucsoft.beeper.button.record.RecordButtonListener;
import com.eucsoft.beeper.http.test.PlayAudioButtonListener;
import com.eucsoft.beeper.http.test.TestButtonListener;

public class MainActivity extends Activity {
	
	static public Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButtons();
		context = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void addListenerOnButtons() {
		ImageButton changeButton = (ImageButton) findViewById(R.id.spinRouletteButton);
		changeButton.setOnClickListener(new TestButtonListener());
		
		Beeper.connect();
		
		AudioPlayThread playThread = new AudioPlayThread();
		playThread.start();
		
		Button button = (Button) findViewById(R.id.recordButton);
		button.setOnTouchListener(new RecordButtonListener());
		
		Button playAudioButton = (Button) findViewById(R.id.playButton);
		playAudioButton.setOnClickListener(new PlayAudioButtonListener());
	}

}
