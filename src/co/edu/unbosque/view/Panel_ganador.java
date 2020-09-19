package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_ganador extends JPanel{

	private ImageIcon imagen;
	private Icon icono;
	private JLabel texto,fondo;
	
	public Panel_ganador() {
		setLayout(null);
		
		texto= new JLabel("GANO EL PRIMER JUGADOR");
		texto.setBounds(120,10,200,40);
		add(texto);
		
		imagen= new ImageIcon(("imagenes/Ganador.gif"));
		icono= new ImageIcon(imagen.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT));
		
		fondo= new JLabel(icono);
		fondo.setBounds(0,0,400,300);
		add(fondo);
	}

	public JLabel getTexto() {
		return texto;
	}

	public void setTexto(JLabel texto) {
		this.texto = texto;
	}
	
}
