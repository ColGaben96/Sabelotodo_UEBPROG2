package co.edu.unbosque.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	private ArrayList<AddressPair> addresses = new ArrayList<>();
	private Scanner sc= new Scanner(System.in);

	public String checkIP() throws IOException {
		IPControl ipControl = new IPControl();
		ipControl.checkIP();
		return ipControl.getIp();
	}

	public void sendMessage() throws IOException {
		//System.out.print("Enter a string: ");
		String str= sc.nextLine();
		buf = str.getBytes();

		for (AddressPair address : addresses) {
			DatagramPacket response = new DatagramPacket(buf, buf.length, address.getAddress(), address.getPort());
			socket.send(response);
		}

	}

	public void run() throws IOException, InterruptedException {
		socket = new DatagramSocket(8888);
		running = true;
		System.out.println("IP: "+checkIP()+":"+8888);
		while (running) {
			Thread listenT = new Thread(() -> {
				while(true) {
					try {
						DatagramPacket packet
								= new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						addresses.add(new AddressPair(packet.getAddress(), packet.getPort()));
						String received
								= new String(packet.getData(), 0, packet.getLength());
						System.out.println(received);
					} catch (IOException e) {
						try {
							run();
						} catch (IOException | InterruptedException ioException) {
							ioException.printStackTrace();
						}
					}
				}
			});
			listenT.join();
			Thread speakT = new Thread(() -> {
				while(true) {
					try {
						sendMessage();
					} catch (IOException e) {
						try {
							run();
						} catch (IOException | InterruptedException ioException) {
							ioException.printStackTrace();
						}
					}
				}
			});
			speakT.join();
			listenT.interrupt();
			speakT.interrupt();
		}
	}
}
