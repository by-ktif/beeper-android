package com.eucsoft.beeper;

import java.io.IOException;

import com.eucsoft.beeper.server.Server;

public class Beeper {
	
	public static String onMessage() {
		return null;
	}
	
	public static String onCloseRoom() {
		return null;
	}

	public static String connect() {
		try {
			Server.connect();
			return Server.send("{action: connect, id: 456456456, info: android-test}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String changeRoom() {
		return null;
	}
	
	public static void startSendMessage() {
	}
	
	public static void sendMessage() {
	}
	
	public static void endSendMessage() {
	}
	
	public static String disconnect() {
		return null;
	}

}
