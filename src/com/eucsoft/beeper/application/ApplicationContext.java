package com.eucsoft.beeper.application;

import java.util.Random;

public class ApplicationContext {
	
	public static final String userId = Integer.toString(Math.abs((new Random()).nextInt()));
	public static final String channelId = Integer.toString(Math.abs((new Random()).nextInt()));
	public static final String serverUrl = "http://192.168.1.101:8080";
	public static final String uploadUrl = "upload.do";

}
