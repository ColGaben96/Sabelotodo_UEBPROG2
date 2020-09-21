package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	private ArrayList<AddressPair> addresses = new ArrayList<>();
	private Timer timer;

	public String checkIP() throws IOException {
		IPControl ipControl = new IPControl();
		ipControl.checkIP();
		return ipControl.getIp();
	}

	public void sendMessage(String message, AddressPair addressPair) throws IOException {
		var buf2 = message.getBytes();
		DatagramPacket packet2
				= new DatagramPacket(buf2, buf2.length,
				addressPair.getAddress(), addressPair.getPort());
		socket.send(packet2);
	}

	public void sendMessageForAll(String message) throws IOException {
		var buf2 = message.getBytes();
		for (AddressPair addressPair: addresses) {
			DatagramPacket packet2
					= new DatagramPacket(buf2, buf2.length,
					addressPair.getAddress(), addressPair.getPort());
			socket.send(packet2);
		}
	}

	public void run() throws IOException, InterruptedException {
		Controller controller = new Controller();
		socket = new DatagramSocket(8888);
		running = true;
		System.out.println("IP: "+checkIP()+":"+8888);
		controller.openQuestionsFile();
		Thread listenT = new Thread(() -> {
			while(true) {
				try {
					DatagramPacket packet
							= new DatagramPacket(buf, buf.length);
					socket.receive(packet);
					System.out.println("Connected: "+packet.getAddress());
					var addressPair = new AddressPair(packet.getAddress(), packet.getPort());
					addresses.add(addressPair);
					sendMessage("***", addressPair);
					if(addresses.size() ==2) {
						System.out.println("ya pueden jugar");
						var question = controller.serverReadQuestion();
						sendMessageForAll("Q:"+question);
						timer = new Timer(1000, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									sendMessageForAll("t");
								} catch (IOException ioException) {
									ioException.printStackTrace();
								}
							}
						});
						timer.start();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		listenT.start();
	}
}
