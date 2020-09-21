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
	private boolean connected = false;
	private String myIP;


	public void run(Controller c) throws IOException {
		IPControl ip = new IPControl();
		ip.checkIP();
		myIP = ip.getIp();
		Thread sMessage = new Thread(() -> {
			try {
				socket = new DatagramSocket();
				buf = (myIP+": me conecte!").getBytes();
				address = InetAddress.getByName("190.24.186.193");
				socket.connect(address, 8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8888);
				socket.send(packet);
				buf = "wdfbHIBCHWEFBHJFBHKDFDJKSBFKDFHDSBFHDBFKADBASBFHJADFBHJADBDHSBFDJASBFHJADFBHKDSBFHDSABFJADSBKFJBASKJDFBDASJKBFDJASKFBKJADSBKJDSBFDSABFDKSJ".getBytes();
				packet = new DatagramPacket(buf, buf.length);
				var response = "";
				while (!(response.equals("!!!"))) {
					socket.receive(packet);
					response = new String(packet.getData(),0, packet.getLength());
					System.out.println(response);
					if(response.equals("***")) {
						connected = true;
					}
					if(response.equals("T")) {
						System.out.println("t");
					}
					if(response.startsWith("Q:")) {
						c.paintQuestions(response);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		sMessage.start();
		try {
			Thread.sleep(250);
		} catch (Exception e) {

		}
	}

	public boolean checkConnection() {
		return connected;
	}

	public void sendResponse(String message) throws IOException {
		buf = (myIP+": "+message).getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8888);
		socket.send(packet);
	}

	public void close() {
		socket.close();
	}

}
