package co.edu.unbosque.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	private Socket socket = null;
	//private DataInputStream in = null;
	private DataOutputStream out = null;
	
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
			socket = new Socket("186.31.44.159", 8080);
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeMessage(String message) {
		try {
			out.writeUTF(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void stop() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
