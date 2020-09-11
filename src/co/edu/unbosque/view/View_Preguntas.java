package co.edu.unbosque.view;

import javax.swing.JFrame;

public class View_Preguntas extends JFrame{

	private Panel_preguntas preguntas;
	
	public View_Preguntas() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		getContentPane().setLayout(null);
		
		preguntas= new Panel_preguntas();
		preguntas.setBounds(0,0,800,600);
		add(preguntas);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public Panel_preguntas getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Panel_preguntas preguntas) {
		this.preguntas = preguntas;
	}
}
