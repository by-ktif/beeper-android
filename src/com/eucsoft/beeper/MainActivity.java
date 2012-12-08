package com.eucsoft.beeper;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.eucsoft.beeper.button.record.RecordButtonListener;
import com.eucsoft.beeper.http.test.TestButtonListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void addListenerOnButtons() {
		Button button = (Button) findViewById(R.id.recordButton);
		button.setOnClickListener(new RecordButtonListener());
		
		Button testButton = (Button) findViewById(R.id.testButton);
		testButton.setOnClickListener(new TestButtonListener());
	}

}
