package com.eucsoft.beeper.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import com.eucsoft.beeper.Config;

public class Server {

	private static Socket socket;
	private static InputStream input;
	private static OutputStream output;
	
	public static void setSocket(Socket socket) {
		Server.socket = socket;
	}
	
	private Server() {
	}
	
	public static void connect() throws IOException {
		if (Server.socket == null) {
			Server.socket = new Socket(Config.BEEPER_HOST, Config.BEEPER_PORT);
		}
		input = socket.getInputStream();
		output = socket.getOutputStream();
	}
	
	public static String send(String message) {
		write(message.getBytes());
		return new String( read() );
	}
	
	public static String send(byte[] message) {
		write(message);
		return new String( read() );
	}
	
	private static byte[] read() {
		try {
			socket.setSoTimeout(Config.SOCKET_TIMEOUT);
			byte[] buffer = new byte[ Config.BUFFER_READ_SIZE ];
			ByteArrayOutputStream requset = new ByteArrayOutputStream();
			int messageSize = 0;
			
			while (true) {
				messageSize = input.read(buffer);
				
				if (messageSize == -1) {
					break;
				}
				requset.write(buffer, 0, messageSize);
			}
			
			if (requset.size() > 0) {
				return requset.toByteArray();
			} else {
				return null;
			}
			
		} catch (SocketTimeoutException e) {
			//ignore timeout.
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void write(byte[] request) {
		try {
			output.write(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
