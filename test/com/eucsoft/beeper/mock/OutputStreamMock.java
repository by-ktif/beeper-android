package com.eucsoft.beeper.mock;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamMock extends OutputStream {

	@Override
	public void write(int oneByte) throws IOException {
		//ignore all
	}

}
