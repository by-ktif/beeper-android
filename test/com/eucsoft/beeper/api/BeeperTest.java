package com.eucsoft.beeper.api;

import java.io.IOException;

import android.test.AndroidTestCase;

import com.eucsoft.beeper.Beeper;
import com.eucsoft.beeper.mock.SocketMock;
import com.eucsoft.beeper.server.Server;


public class BeeperTest extends AndroidTestCase {
	
	public void connectTest() throws IOException {
		String expected = "{action: connect, status: 200}";
		Server.setSocket(new SocketMock(expected));
		
		String actual = Beeper.connect();
		assertEquals(expected, actual);
	}
	
	public void changeRoomTest() {
		Beeper.changeRoom();
		assertTrue(false);
	}
	
	public void onMessageTest() {
		Beeper.onMessage();
		assertTrue(false);
	}
	
}
