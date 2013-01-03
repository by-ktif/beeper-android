package com.eucsoft.beeper.http.test;

import android.view.View;
import android.view.View.OnClickListener;

public class PlayAudioButtonListener implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		System.exit(0);
		// Later… 
		//TestButtonListener.client.send("hello!");
		//client.send(new byte[] { 0xDE, 0xAD, 0xBE, 0xEF });
		/*try {
			TestButtonListener.client.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
