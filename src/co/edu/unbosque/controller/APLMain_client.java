package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <h1>Description</h1><br>
 *     <p>Class to run client</p>
 * @author Gabriel Blanco
 * @version 1.0
 */
public class APLMain_client {

	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
		c.startClient();
	}

}
