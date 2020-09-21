package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Server {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	private ArrayList<AddressPair> addresses = new ArrayList<>();
	private Timer timer;
	private int counter = 0;

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
			if(addressPair.isPlaying()) {
				DatagramPacket packet2
						= new DatagramPacket(buf2, buf2.length,
						addressPair.getAddress(), addressPair.getPort());
				socket.send(packet2);
			}
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
					if(counter == 5) {
						sendMessageForAll("!!!");
						removeAddressesFromList(addresses.get(0),addresses.get(1));
					}
					DatagramPacket packet
							= new DatagramPacket(buf, buf.length);
					socket.receive(packet);
					var client = new String(packet.getData(), 0, packet.getLength());
					System.out.println(client);
					if(client.contains("A:")) {
						var ans = client.split(":");
						sendMessageForAll("SR-"+ans[0]+":"+controller.checkAnswer(Integer.parseInt(ans[2])));
						counter++;
					}
					var addressPair = new AddressPair(packet.getAddress(),
							packet.getPort(), addresses.size() < 2);
					addresses.add(addressPair);
					sendMessage("***", addressPair);
					var question = controller.serverReadQuestion();
					sendMessageForAll("Q:"+question);
					controller.paintQuestions(question);
					timer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							/*try {
								sendMessageForAll("T");
							} catch (IOException ioException) {
								ioException.printStackTrace();
							}*/
						}
					});
					timer.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		listenT.start();
	}

	public void removeAddressesFromList(AddressPair address1, AddressPair address2) {
		for (AddressPair addressPair: addresses) {
			if(addressPair.getAddress() == address1.getAddress()) {
				addresses.remove(addressPair);
			}
			if(addressPair.getAddress() == address2.getAddress()) {
				addresses.remove(addressPair);
			}
		}
		if(addresses.size() >=2) {
			addresses.get(0).setPlaying(true);
			addresses.get(1).setPlaying(true);
		} else if(addresses.size() == 1) {
			addresses.get(0).setPlaying(true);
		}
	}
}
