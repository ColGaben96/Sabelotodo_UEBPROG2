package co.edu.unbosque.controller;

import co.edu.unbosque.model.Sabelotodo;
import co.edu.unbosque.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Gabriel Blanco - Juan Pablo Araque - Laura Chiquillo - Sebastian Cubillos
 * @version 1.0
 */
public class Controller implements ActionListener {
	
	private Client client = new Client();
	private Server server = new Server();
	private Sabelotodo model = new Sabelotodo();
	public MainView view = new MainView();

	
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
					System.out.println("ERROR: Opci�n inv�lida. Por favor ingresa las opciones disponibles.");
					break;
				case 0:
					active = false;
					sc.close();
					break;
				case 1:
					//Se va a solicitar crear un nuevo hilo por cliente.
					//Debe estar el srv activo antes de crear un cliente.
					Thread thread = new Thread(() -> {
						try {
							startClient();
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
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
	public void startClient() throws IOException {
		view.start(this);
	}
	
	/**
	 * <h1>Description</h1>
	 * <p>Method to start <b>server</b></p>
	 * @author Gabriel Blanco
	 */
	public void startServer() throws IOException, InterruptedException {
		Thread tServer = new Thread(() -> {
			try {
				server.run();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		});
		tServer.start();
		model.startServer();
	}

	/**
	 * @author Laura Chiquillo - Sebastian Cubillos
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(view.getMainMenu().JUGAR)) {
			try {
				client.run(this);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			if(client.checkConnection()) {
				view.goGame();
			} else {
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals(view.getMainMenu().SALIR)) {
			System.exit(0);
		}
		if(e.getActionCommand().equals(view.getInGame().UNO)) {
			if(client.checkConnection()) {
				try {
					client.sendResponse("A:1");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} else {
				view.goMain();
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		if(e.getActionCommand().equals(view.getInGame().DOS)) {
			if(client.checkConnection()) {
				try {
					client.sendResponse("A:2");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} else {
				view.goMain();
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		if(e.getActionCommand().equals(view.getInGame().TRES)) {
			if(client.checkConnection()) {
				try {
					client.sendResponse("A:3");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} else {
				view.goMain();
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		if(e.getActionCommand().equals(view.getInGame().CUATRO)) {
			if(client.checkConnection()) {
				try {
					client.sendResponse("A:4");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} else {
				view.goMain();
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		if(e.getActionCommand().equals(view.getInGame().AYUDA)) {
			if(client.checkConnection()) {
				try {
					client.sendResponse("H:");
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			} else {
				view.goMain();
				JOptionPane.showMessageDialog(null, "Verifica tu conexion a internet y e intenta nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	/**
	 * <h1>Description</h1><br>
	 *     <p><b>CAUTION:</b> This method is only for server use <br>
	 *        This method checks from a DAO and return the info just to print it in the client</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public String serverReadQuestion() {
		return model.getQuestion();
	}
	/**
	 * <h1>Description</h1><br>
	 *     <p><b>CAUTION:</b> This method is only for server use <br>
	 *        This method prints the question with the server's info</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public void paintQuestions(String question) {
		view.refreshGame(question);
	}
	/**
	 * <h1>Description</h1><br>
	 *     <p><b>CAUTION:</b> This method is only for server use <br>
	 *        This method checks the validation of the answers.</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public boolean checkAnswer(int answer) {
		return model.checkAnswer(answer);
	}
	/**
	 * <h1>Description</h1><br>
	 *     <p><b>CAUTION:</b> This method is only for server use <br>
	 *        This method opens a file which contains all the questions</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public void openQuestionsFile() throws IOException {
		model.startServer();
	}
	/**
	 * <h1>Description</h1><br>
	 *     <p><b>CAUTION:</b> This method is only for client use <br>
	 *        This method checks from a DAO and return the info just to print it in the client</p>
	 * @author Gabriel Blanco
	 * @return
	 */
	public void goMain() {
		view.goMain();
	}

	/**
	 * @author Juan Pablo Araque
	 */
	public void eliminarOpcionesRespuesta() {
		if(model.getRespuestaCorrecta()==1) {
			view.getInGame().getTres().setVisible(false);
			view.getInGame().getDos().setVisible(false);
		}
		else if(model.getRespuestaCorrecta()==2) {
			view.getInGame().getTres().setVisible(false);
			view.getInGame().getCuatro().setVisible(false);
		}
		else if(model.getRespuestaCorrecta()==3) {
			view.getInGame().getUno().setVisible(false);
			view.getInGame().getCuatro().setVisible(false);
		}
		else {
			view.getInGame().getDos().setVisible(false);
			view.getInGame().getTres().setVisible(false);
		}
	}
}
