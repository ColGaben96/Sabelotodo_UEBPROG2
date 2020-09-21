package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

/**
 * <h1>Description</h1>
 * <p>Class to communicate with Server.</p>
 * @author Gabriel Blanco
 * @version 1.0
 */
public class Client {

	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buf;
	private boolean connected = false;
	private String myIP;

	/**
	 * <h1>Description</h1>
	 * <p>This method coordinates the data transfer via UDP. This because this client is not the only one who will connect.</p>
	 * @author Gabriel Blanco
	 * @param c
	 * @throws IOException
	 */
	public void run(Controller c) throws IOException {
		IPControl ip = new IPControl();
		ip.checkIP();
		myIP = ip.getIp();
		Thread sMessage = new Thread(() -> {
			try {
				socket = new DatagramSocket();
				buf = (myIP+": me conecte!").getBytes();
				address = InetAddress.getByName("190.24.186.193"); //This is the IP. Make sure you got internet access first.
				socket.connect(address, 8888); //This socket connects to the server
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8888); //Build a packet
				socket.send(packet); //Send a packet to say I connected
				//This buf is a long string because there are some questions that are way too long. In case that character quantity exceed this string quantity, the message will be incomplete.
				buf = "wdfAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAbHIBCHWEFBHJFBHKDFDJKSBFKDFHDSBFHDBFKADBASBFHJADFBHJADBDHSBFDJASBFHJADFBHKDSBFHDSABFJADSBKFJBASKJDFBDASJKBFDJASKFBKJADSBKJDSBFDSABFDKSJ".getBytes();
				packet = new DatagramPacket(buf, buf.length);
				var response = ""; //Some response validations.
				while (!(response.equals("!!!"))) {
					socket.receive(packet);
					response = new String(packet.getData(),0, packet.getLength());
					System.out.println(response);
					if(response.equals("***")) {
						connected = true;
					}
					if(response.equals("T")) {
						//System.out.println("t");
					}
					if(response.startsWith("Q:")) {
						c.paintQuestions(response);
					}
				}
				c.goMain();
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

	/**
	 * <h1>Description</h1><br>
	 *     <p>This method just checks if has connection</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public boolean checkConnection() {
		return connected;
	}

	/**
	 * <h1>Description</h1>
	 * <p>This method sends a message to the server</p>
	 * @author Gabriel Blanco
	 * @param message
	 * @throws IOException
	 */
	public void sendResponse(String message) throws IOException {
		buf = (myIP+": "+message).getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8888);
		socket.send(packet);
	}

}
