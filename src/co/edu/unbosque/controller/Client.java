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
			IPControl control = new IPControl();
			System.out.println("Please wait...");
			socket = new Socket(control.PRUEBAS, 8888);
			System.out.println("Connection Successful");
			online();
		} catch(SocketException badSocket) {
			System.out.println("Check your internet connection and try again. "+badSocket.getMessage());
			System.exit(1);
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
			msg = sc.nextLine();
			if(msg.equals("quit")){
				listening = false;
				socket.close();
			}
			out.writeUTF(msg);
			Thread listen = new Thread(() -> {
				try {
					System.out.println("Server: "+in.readUTF());
				} catch (IOException e) {
					System.out.print("Server: ");System.err.print("Oh noes! Server's down");
				}
			});
			listen.start();
			if(socket.isConnected()) {
				listen.interrupt();
			}
		}
		socket.close();
		System.out.println("Connection Terminated");
	}
}
