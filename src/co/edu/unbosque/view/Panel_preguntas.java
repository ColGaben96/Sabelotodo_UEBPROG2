package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panel_preguntas extends JPanel{

	private JTextArea pregunta,p1,p2;
	private JButton uno,dos,tres,cuatro,ayuda;
	private JLabel punto1,fondo,punto2,a,b,c,d;
	private Icon icono,ico;
	private ImageIcon imagen,im;
	
	public Panel_preguntas() {
		setLayout(null);
		
		pregunta= new JTextArea();
		pregunta.setBounds(140,80,500,200);
		add(pregunta);
		
		punto1= new JLabel("Puntos jugador1");
		punto1.setBounds(200,20,100,40);
		punto1.setForeground(Color.WHITE);
		add(punto1);
		
		p1= new JTextArea();
		p1.setBounds(300,30,20,20);
		add(p1);
		
		punto2= new JLabel("Puntos jugador2");
		punto2.setBounds(400,20,100,40);
		punto2.setForeground(Color.WHITE);
		add(punto2);
		
		p2= new JTextArea();
		p2.setBounds(500,30,20,20);
		add(p2);
		
		a= new JLabel("A.");
		a.setBounds(140,310,200,40);
		a.setForeground(Color.WHITE);
		add(a);
		
		uno= new JButton("");
		uno.setBounds(140,350,200,40);
		add(uno);
		
		b= new JLabel("B.");
		b.setBounds(440,310,200,40);
		b.setForeground(Color.WHITE);
		add(b);
		
		dos= new JButton("");
		dos.setBounds(440,350,200,40);
		add(dos);
		
		c= new JLabel("C.");
		c.setBounds(140,400,200,40);
		c.setForeground(Color.WHITE);
		add(c);
		
		tres= new JButton("");
		tres.setBounds(140,430,200,40);
		add(tres);
		
		d= new JLabel("D.");
		d.setBounds(440,400,200,40);
		d.setForeground(Color.WHITE);
		add(d);
		
		cuatro= new JButton("");
		cuatro.setBounds(440,430,200,40);
		add(cuatro);
		
		im= new ImageIcon(("imagenes/Presentación1.jpg"));
		ico= new ImageIcon(im.getImage().getScaledInstance(410,250,Image.SCALE_DEFAULT));
		
		ayuda= new JButton(ico);
		ayuda.setBounds(660,150,100,100);
		add(ayuda);
		
		imagen= new ImageIcon(("imagenes/x.jpg"));
		icono= new ImageIcon(imagen.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT));
		
		fondo= new JLabel(icono);
		fondo.setBounds(0,0,800,600);
		add(fondo);
	}
}
