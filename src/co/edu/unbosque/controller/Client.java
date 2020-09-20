package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Client {

	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buf;


	public void run() throws IOException {
		Thread sMessage = new Thread(() -> {
			try {
				socket = new DatagramSocket();
				byte[] ipAddr = new byte[] { (byte)186, (byte)28, (byte)58,(byte) 158 };
				address = InetAddress.getLocalHost();
				socket.connect(address,8888);
				buf = "me conecte!".getBytes();
				DatagramPacket packet
						= new DatagramPacket(buf, buf.length, address, 8888);
				socket.send(packet);
				//while(true) {
				//sendEcho();
				//}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		sMessage.start();
	}

	public String sendEcho() throws IOException {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream
		System.out.print("Enter a string: ");
		String str= sc.nextLine();
		buf = str.getBytes();
		DatagramPacket packet
				= new DatagramPacket(buf, buf.length, address, 8888);
		socket.send(packet);

		str= sc.nextLine();
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		String received = new String(
				packet.getData(), 0, packet.getLength());
		System.out.println(received);
		return received;
	}

	public void close() {
		socket.close();
	}

}
