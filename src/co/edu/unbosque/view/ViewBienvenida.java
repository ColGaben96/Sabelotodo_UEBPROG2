package co.edu.unbosque.view;

import javax.swing.JFrame;

public class ViewBienvenida extends JFrame{
	
	private PanelBienvenida panelBienvenida;
	
	public ViewBienvenida() {
		
		//setUndecorated(true);
		setSize(800, 600);
		setResizable(false);
		setTitle("SABELOTODO"); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelBienvenida = new PanelBienvenida();
		panelBienvenida.setBounds(0, 0, 800, 600);
		getContentPane().add(panelBienvenida);
		
	}
	public PanelBienvenida getPanelBienvenida() {
		return panelBienvenida;
	}
	public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
		this.panelBienvenida = panelBienvenida;
	}
}