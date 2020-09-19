package co.edu.unbosque.controller;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import co.edu.unbosque.view.ViewBienvenida;
import co.edu.unbosque.view.View_Preguntas;
import co.edu.unbosque.view.View_empate;
import co.edu.unbosque.view.View_ganador;

/**
 * @author Gabriel Blanco - Juan Pablo Araque - Laura Chiquillo - Sebastian Cubillos
 * @version 1.0
 */
public class Controller implements ActionListener {
	
	private Client client = new Client();
	private Server server = new Server();
	private View_Preguntas ven_preguntas;
	private ViewBienvenida ven_principal;
	private View_ganador ven_ganador;
	private View_empate ven_empate;
	
	/**
	 * <h1>Description</h1>
	 * <p>Method for <b>debugging</b> purposes</p>
	 * @author Gabriel Blanco
	 */

	private ViewBienvenida ven_principal;
	public Controller() {
		ven_principal= new ViewBienvenida();
		ven_principal.setVisible(true);
		ven_principal.getPanelBienvenida().getBotonJugar().addActionListener(this);
		ven_preguntas= new View_Preguntas();
		ven_preguntas.setVisible(false);
		ven_ganador= new View_ganador();
		ven_ganador.setVisible(false);
		ven_empate= new View_empate();
		ven_empate.setVisible(false);
	}
	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(ven_principal.getPanelBienvenida().getBotonJugar())) {
			ven_preguntas.setVisible(true);
			ven_principal.setVisible(false);
		}
		
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		var active = true;
		while(active) {
			try {
				System.out.print("Ingresa una opcion [0|1|2|3] ");
				var option = sc.nextInt();
				switch(option) {
				default:
					System.out.println("ERROR: Opci�n inv�lida. Por favor ingresa las opciones disponibles.");
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
					//No se solicita crear un nuevo hilo, ya que la ejecuci�n del srv es por aparte.
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
				System.out.println("ERROR: Opci�n inv�lida. Por favor ingresa las opciones disponibles.");
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
