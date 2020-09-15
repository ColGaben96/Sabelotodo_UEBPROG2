package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_empate extends JPanel{

	private ImageIcon imagen;
	private Icon icono;
	private JLabel fondo;
	
	public Panel_empate() {
		setLayout(null);
		
		imagen= new ImageIcon(("imagenes/Empate.gif"));
		icono= new ImageIcon(imagen.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT));
		
		fondo= new JLabel(icono);
		fondo.setBounds(0,0,400,300);
		add(fondo);
	}
}
