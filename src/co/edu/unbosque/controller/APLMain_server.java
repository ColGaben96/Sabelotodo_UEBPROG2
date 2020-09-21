package co.edu.unbosque.controller;

import java.io.IOException;

/**
 * <h1>Description</h1><br>
 * <p>Class to run server. This is already running in Gabriel's home.</p>
 * @author Gabriel Blanco
 * @version 1.0
 */
public class APLMain_server {

	public static void main(String[] args) throws IOException, InterruptedException {
		Controller c = new Controller();
		c.startServer();
	}

}
