package com.eucsoft.beeper.mock;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public class SocketMock extends Socket {
	
	@Override
	public void bind(SocketAddress bindpoint) {
	}

	@Override
	public void close() {
	}
	
	@Override
	public void connect(SocketAddress endpoint) {
	}

	@Override
	public void connect(SocketAddress endpoint, int timeout) {
	}
	
	@Override
	public SocketChannel getChannel() {
		return null;
	}
	
	@Override
	public InetAddress getInetAddress() {
		return null;
	}

	@Override
	public InputStream getInputStream() {
		return new InputStreamMock();
	}

	@Override
	public boolean getKeepAlive() {
		return false;
	}

	@Override
	public InetAddress getLocalAddress() {
		return null;
	}

	@Override
	public int getLocalPort() {
		return 0;
	}

	@Override
	public SocketAddress getLocalSocketAddress() {
		return null;
	}
	
	@Override
	public boolean getOOBInline() {
		return false;
	}

	@Override
	public OutputStream getOutputStream() {
		return new OutputStreamMock();
	}

	@Override
	public int getPort() {
		return 0;
	}

	@Override
	public int getReceiveBufferSize() {
		return 0;
	}

	@Override
	public SocketAddress getRemoteSocketAddress() {
		return null;
	}

	@Override
	public boolean getReuseAddress() {
		return false;
	}

	@Override
	public int getSendBufferSize() {
		return 0;
	}

	@Override
	public int getSoLinger() {
		return 0;
	}

	@Override
	public int getSoTimeout() {
		return 0;
	}

	@Override
	public boolean getTcpNoDelay() {
		return false;
	}

	@Override
	public int getTrafficClass() {
		return 0;
	}

	@Override
	public boolean isBound() {
		return false;
	}

	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public boolean isConnected() {
		return false;
	}

	@Override
	public boolean isInputShutdown() {
		return false;
	}

	@Override
	public boolean isOutputShutdown() {
		return false;
	}

	@Override
	public void sendUrgentData(int data) {
	}

	@Override
	public void setKeepAlive(boolean on) {
	}

	@Override
	public void setOOBInline(boolean on) {
	}

	@Override
	public void setReceiveBufferSize(int size) {
	}

	@Override
	public void setReuseAddress(boolean on) {
	}

	@Override
	public void setSendBufferSize(int size) {
	}

	@Override
	public void setSoLinger(boolean on, int linger) {
	}

	@Override
	public void setSoTimeout(int timeout) {
	}

	@Override
	public void setTcpNoDelay(boolean on) {
	}

	@Override
	public void setTrafficClass(int tc) {
	}

	@Override
	public void shutdownInput() {
	}
	
	@Override
	public void shutdownOutput() {
	}

	@Override
	public String toString() {
		return "";
	}

}
