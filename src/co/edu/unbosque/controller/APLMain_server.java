package co.edu.unbosque.controller;

import java.io.IOException;

public class APLMain_server {

	public static void main(String[] args) throws IOException, InterruptedException {
		Controller c = new Controller();
		c.startServer();
	}

}
