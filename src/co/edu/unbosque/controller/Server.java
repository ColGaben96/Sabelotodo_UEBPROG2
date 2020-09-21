package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * <h1>Description:</h1><br>
 *     <p>Class where the magic literally happens</p>
 * @author Gabriel Blanco - Juan Pablo Araque
 * @version 1.0
 */
public class Server {

	private DatagramSocket socket;
	private boolean running;
	private byte[] buf = new byte[256];
	private ArrayList<AddressPair> addresses = new ArrayList<>();
	private Timer timer;
	private int counter = 0;
	private int contAyuda=0;

	/**
	 * <h1>Description:</h1>
	 * <p>Method where server checks it's ip</p>
	 * @author Gabriel Blanco
	 * @return
	 * @throws IOException
	 */
	public String checkIP() throws IOException {
		IPControl ipControl = new IPControl();
		ipControl.checkIP();
		return ipControl.getIp();
	}

	/**
	 * <h1>Description:</h1><br>
	 *     <p>Method where server can send a message to specific client</p>
	 * @author Gabriel Blanco
	 * @param message
	 * @param addressPair
	 * @throws IOException
	 */
	public void sendMessage(String message, AddressPair addressPair) throws IOException {
		var buf2 = message.getBytes();
		DatagramPacket packet2
				= new DatagramPacket(buf2, buf2.length,
				addressPair.getAddress(), addressPair.getPort());
		socket.send(packet2);
	}

	/**
	 * <h1>Description:</h1><br>
	 * <p>Method where server can send to everyone</p>
	 * @author Gabriel Blanco
	 * @param message
	 * @throws IOException
	 */
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

	/**
	 * <h1>Description:</h1><br>
	 * <p>Method where the magic comes true</p>
	 * @author Gabriel Blanco - Juan Pablo Araque
	 * @throws IOException
	 * @throws InterruptedException
	 */
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
					if(client.contains("H:")) {
						var clientStructure = client.split(":");
						if(clientStructure[0].equals(String.valueOf(addresses.get(0)))) {
							sendMessage("HP:"+controller.getRespuesta(), addresses.get(0));
						} else {
							sendMessage("HP:"+controller.getRespuesta(), addresses.get(1));
						}
						contAyuda++;
					}
					var addressPair = new AddressPair(packet.getAddress(),
							packet.getPort(), addresses.size() < 2);
					addresses.add(addressPair);
					sendMessage("***", addressPair);
					if(addresses.size() % 2 == 0) {
						var question = controller.serverReadQuestion();
						sendMessageForAll("Q:"+question);
						controller.paintQuestions(question);
					}
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

	/**
	 * <h1>Description:</h1><br>
	 *     <p>Method where 2 clients are deleted</p>
	 * @author Gabriel Blanco
	 * @param address1
	 * @param address2
	 */
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

	/**
	 * @author Juan Pablo Araque
	 * @param puntaje
	 * @param correcto
	 * @return
	 */
	public int calcularPuntaje(int puntaje,boolean correcto) {
		if(correcto && contAyuda==0)
			return 3;
		else if(correcto && contAyuda==1)
			return 1;
		else if(!correcto && puntaje>0)
			return -2;
		else
			return 0;
	}
}
