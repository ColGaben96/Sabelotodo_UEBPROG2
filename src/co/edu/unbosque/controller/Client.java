package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
	private Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	private Scanner sc = new Scanner(System.in);

	public void run() {
		try {
			System.out.println("Please wait...");
			socket = new Socket("186.31.44.159", 8888);
			System.out.println("Connection Successful");
			online();
		} catch(SocketException badSocket) {
			System.out.println("Check your internet connection and try again. "+badSocket.getMessage());
		} catch (IOException io) {
			System.out.println("Client has an unexpected error: "+io.getMessage());
		}
	}

	public void online() throws IOException {
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		boolean listening = true;
		String msg = null;
		while(listening) {
			System.out.print("> ");
			msg = sc.nextLine();
			if(msg.equals("quit")){
				listening = false;
				socket.close();
			}
			out.writeUTF(msg);
			System.out.println("Server: "+in.readUTF());
		}
		socket.close();
		System.out.println("Connection Terminated");
	}
}
