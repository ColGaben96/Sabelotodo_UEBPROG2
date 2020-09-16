package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Gabriel Blanco - Juan Pablo Araque
 * @version 1.0
 */
public class Controller {
	
	private Client client = new Client();
	private Server server = new Server();
	
	/**
	 * <h1>Description</h1>
	 * <p>Method for <b>debugging</b> purposes</p>
	 * @author Gabriel Blanco
	 */
	public void start() {
		Scanner sc = new Scanner(System.in);
		var active = true;
		while(active) {
			try {
				System.out.print("Ingresa una opcion [0|1|2|3] ");
				var option = sc.nextInt();
				switch(option) {
				default:
					System.out.println("ERROR: Opción inválida. Por favor ingresa las opciones disponibles.");
					break;
				case 0:
					active = false;
					sc.close();
					break;
				case 1:
					//Se va a solicitar crear un nuevo hilo por cliente.
					//Debe estar el srv activo antes de crear un cliente.
					Thread thread = new Thread(this::startClient);
					thread.start();
					break;
				case 2:
					//No se solicita crear un nuevo hilo, ya que la ejecución del srv es por aparte.
					startServer();
					break;
				case 3:
					URL myIP = new URL("http://checkip.amazonaws.com");
					BufferedReader in = new BufferedReader(new InputStreamReader(
			                myIP.openStream()));
					String ip = in.readLine();
					System.out.println(ip);
					System.out.println("Holis");
					break;
				}
			} catch (Exception e) {
				System.out.println("ERROR: Opción inválida. Por favor ingresa las opciones disponibles.");
				start();
			}
		}
	}
	
	/**
	 * <h1>Description</h1>
	 * <p>Method to start <b>client</b></p>
	 * @author Gabriel Blanco
	 */
	public void startClient() {
		client.run();
	}
	
	/**
	 * <h1>Description</h1>
	 * <p>Method to start <b>server</b></p>
	 * @author Gabriel Blanco
	 */
	public void startServer() {
		server.run();
	}
}
