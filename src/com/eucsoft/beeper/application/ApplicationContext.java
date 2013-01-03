package com.eucsoft.beeper.application;

public class ApplicationContext {
	
	public static final String userId = "1";//Integer.toString(Math.abs((new Random()).nextInt()));
	public static final String channelId = "1";//Integer.toString(Math.abs((new Random()).nextInt()));
	
	public static final String httpProtocol = "http://";
	public static final String wsProtocol = "ws://";
	//public static final String ipPort = "80.249.82.36:8080";
	public static final String ipPort = "192.168.1.101:8080";
	public static final String serverUrl = httpProtocol + ipPort;
	public static final String websocketUrl = wsProtocol + ipPort + "/wsocket.doo";
	public static final String uploadUrl = "upload.do";
	
	

}
