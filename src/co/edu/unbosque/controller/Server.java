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
	private Socket clientSocket = null;
	private Scanner sc = new Scanner(System.in);

	public String checkIP() throws IOException {
		IPControl ipControl = new IPControl();
		ipControl.checkIP();
		return ipControl.getIp();
	}

	public void run() {
		System.out.println("Please wait...");
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Server is running on "+checkIP()+":"+8888);
			online();
		} catch (Exception io) {
			System.out.println("Server has an unexpected error. Cause: "+io.getMessage());
		}
	}

	public void noClients() throws Exception {
		serverSocket = new ServerSocket(8888);
		online();
	}

	public void online() throws Exception {
		System.out.println("No clients are connected. Waiting");
		clientSocket = serverSocket.accept();
		System.out.println(clientSocket.getInetAddress().getHostAddress()+" has connected");
		while(clientSocket.isConnected()) {
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			Thread speakThread = new Thread(this::sendMessage);
			speakThread.start();
			Thread listenThread = new Thread(() -> {
				try {
					System.out.println(clientSocket.getInetAddress().getHostAddress()+": "+in.readUTF());
				}
				catch (IOException e) {
					try {
						serverSocket.close();
						noClients();
					} catch (Exception ioException) {
						System.out.println("Oops");
						System.exit(1);
					}
				}
			});
			listenThread.start();
			if(speakThread.isAlive()) {
				listenThread.join();
			} else {
				speakThread.join();
			}
		}
	}

	public synchronized void sendMessage() {
		try {
			String msg = sc.nextLine();
			out.writeUTF(msg);
		} catch (IOException e) {
			System.out.println("Something bad happened");
		}
	}
}
