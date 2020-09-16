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

	public String checkIP() throws IOException {
		IPControl ipControl = new IPControl();
		ipControl.checkIP();
		return ipControl.getIp();
	}

	public void sendMessage() throws IOException {
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream
		System.out.print("Enter a string: ");
		String str= sc.nextLine();
		buf = str.getBytes();

		for (AddressPair address : addresses) {
			DatagramPacket response = new DatagramPacket(buf, buf.length, address.getAddress(), address.getPort());
			socket.send(response);
		}

	}

	public void run() throws IOException {
		socket = new DatagramSocket(4445);
		running = true;

		while (running) {
			Scanner sc= new Scanner(System.in); //System.in is a standard input stream
			System.out.print("Presione lo que le de la gana para continuar leyendo ");
			String str= sc.nextLine();
			DatagramPacket packet
					= new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			addresses.add(new AddressPair(packet.getAddress(), packet.getPort()));
			String received
					= new String(packet.getData(), 0, packet.getLength());
			System.out.println(received);
			sendMessage();
		}
	}
}
