package co.edu.unbosque.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class APLMain_client {

	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
		c.startClient();
	}

}
