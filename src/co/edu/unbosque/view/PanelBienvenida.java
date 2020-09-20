package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBienvenida extends JPanel{
	
	private JButton botonJugar;
	private JButton botonSalir;
	private ImageIcon imagen;
	private Font font;
	private Icon icono;
	private JLabel etiquetaImagen;
	public final String JUGAR = "JUGAR", SALIR = "SALIR";
	
	public PanelBienvenida() {
		
		setLayout(null);
		
		font = new Font("", Font.PLAIN, 35);
		
		botonJugar = new JButton("JUGAR");
		botonJugar.setBounds(130, 430, 250, 80);
		botonJugar.setFont(font);
		botonJugar.setForeground(Color.WHITE);
		botonJugar.setFocusable(false);
		botonJugar.setContentAreaFilled(false);
		botonJugar.setActionCommand(JUGAR);
		add(botonJugar);
		
		botonSalir = new JButton("SALIR");
		botonSalir.setBounds(420, 430, 250, 80);
		botonSalir.setFont(font);
		botonSalir.setForeground(Color.WHITE);
		botonSalir.setFocusable(false);
		botonSalir.setContentAreaFilled(false);
		botonSalir.setActionCommand(SALIR);
		add(botonSalir);
		
		imagen = new ImageIcon(("imagenes/1.gif"));
		icono = new ImageIcon(imagen.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
		
		etiquetaImagen = new JLabel(icono);
		etiquetaImagen.setBounds(0, 0, 800, 600);
		add(etiquetaImagen);
		
	}
	public JButton getBotonJugar() {
		return botonJugar;
	}
	public void setBotonJugar(JButton botonJugar) {
		this.botonJugar = botonJugar;
	}
	public JButton getBotonSalir() {
		return botonSalir;
	}
	public void setBotonSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Icon getIcono() {
		return icono;
	}
	public void setIcono(Icon icono) {
		this.icono = icono;
	}
	public JLabel getEtiquetaImagen() {
		return etiquetaImagen;
	}
	public void setEtiquetaImagen(JLabel etiquetaImagen) {
		this.etiquetaImagen = etiquetaImagen;
	}
}
