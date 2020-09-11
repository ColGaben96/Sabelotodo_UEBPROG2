package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBienvenida extends JPanel{
	
	private JLabel etiquetaSabelotodo;
	private JButton botonJugar;
	private JButton botonSalir;
	
	
	public PanelBienvenida() {
		
		setLayout(null);
		
		etiquetaSabelotodo = new JLabel("SABELOTODO");
	}

}
