package com.eucsoft.beeper.mock;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamMock extends InputStream {
	
	private boolean isMessageReaded = false;;
	private byte[] message; 
	
	public InputStreamMock(String answer) {
		this.message = answer.getBytes(); 
	}
	
	@Override
	public int read(byte[] buffer) throws IOException {
		if (!isMessageReaded) {
			isMessageReaded = true;
			System.arraycopy(message, 0, buffer, 0, message.length );
			return message.length;
		} else {
			isMessageReaded = false;
			return -1;
		}
	}

	@Override
	public int read() throws IOException {
		return -1;
	}

}
