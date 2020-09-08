package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket ssocket = null;
	private Socket socket = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	private final int port = 8080;
	
	public String getStatus(int status) {
		String message = null;
		switch(status) {
		case 0:
			message = "Server is stopped";
			break;
		case 2:
			message = "Server is starting";
			break;
		case 3:
			message = "Client accepted";
			break;
		case 4:
			message = "Client rejected";
			break;
		case 200:
			message = "Server is ready";
			break;
		case 201:
			message = "Server is ready with errors";
			break;
		case 500:
			message = "Server has an unexpected error";
			break;
		}
		return message;
	}
	
	public void run() {
		try {
			ssocket = new ServerSocket(port);
			socket = new Socket(ssocket.getInetAddress(), port);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(getStatus(200));
		} 
		catch (Exception e) {
			System.err.println(getStatus(500));
		}
	}
	
	public void acceptClient() {
		try {
			socket = ssocket.accept();
			out.writeUTF(getStatus(3)+" from "+ssocket.getInetAddress().getHostAddress()+":"+port);
		} catch (IOException e) {
			System.err.println(getStatus(500));
		}
	}
	
	public void stop() {
		try {
			socket.close();
			in.close();
			out.writeUTF(getStatus(0));
		} catch (Exception e) {
			System.err.println(getStatus(500));
		}
	}

}
