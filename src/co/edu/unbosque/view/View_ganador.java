package co.edu.unbosque.view;

import javax.swing.JFrame;

public class View_ganador extends JFrame{

	private Panel_ganador ganador;
	
	public View_ganador() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		getContentPane().setLayout(null);
		
		ganador= new Panel_ganador();
		ganador.setBounds(0,0,400,300);
		add(ganador);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public Panel_ganador getGanador() {
		return ganador;
	}

	public void setGanador(Panel_ganador ganador) {
		this.ganador = ganador;
	}
}
