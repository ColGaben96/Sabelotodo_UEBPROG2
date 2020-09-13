package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server {

	private ServerSocket serverSocket = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	private Scanner sc = new Scanner(System.in);

	public String checkIP() throws IOException {
		ExternalIP exIP = new ExternalIP();
		exIP.checkIP();
		return exIP.getIp();
	}

	public void run() {
		System.out.println("Please wait...");
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Server is running on "+checkIP()+":"+8888);
			online();
		} catch (IOException io) {
			System.out.println("Server has an unexpected error. Cause: "+io.getMessage());
		}
	}

	public void online() throws IOException {
		System.out.println("Waiting for clients...");
		while(true) {
			Socket clientSocket = serverSocket.accept();
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			sendMessage();
			System.out.println(clientSocket.getInetAddress().getHostAddress()+": "+in.readUTF());
		}
	}

	public void sendMessage() throws IOException {
		Thread thread = new Thread(() -> {
			try {
				System.out.print("> ");
				String msg = sc.nextLine();
				out.writeUTF(msg);
			} catch (IOException e) {

			}
		});
		thread.start();
	}
}
