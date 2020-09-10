package co.edu.unbosque.controller;

import java.util.Scanner;

public class Controller {
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		var active = true;
		while(active) {
			try {
				System.out.print("Ingresa una opcion [0|1|2] ");
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
					break;
				case 2:
					break;
				}
			} catch (Exception e) {
				System.out.println("ERROR: Opción inválida. Por favor ingresa las opciones disponibles.");
				start();
			}
		}
	}
	
	public void startClient() {
		
	}
	
	public void startServer() {
		
	}
}
