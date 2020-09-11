package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panel_preguntas extends JPanel{

	private JTextArea pregunta,p1,p2;
	private JButton uno,dos,tres,cuatro,ayuda;
	private JLabel punto1,punto2,a,b,c,d;
	public Panel_preguntas() {
		setLayout(null);
		
		pregunta= new JTextArea();
		pregunta.setBounds(140,80,500,200);
		add(pregunta);
		
		punto1= new JLabel("Puntos jugador1");
		punto1.setBounds(200,20,100,40);
		add(punto1);
		
		p1= new JTextArea();
		p1.setBounds(300,30,20,20);
		add(p1);
		
		punto2= new JLabel("Puntos jugador2");
		punto2.setBounds(400,20,100,40);
		add(punto2);
		
		p2= new JTextArea();
		p2.setBounds(500,30,20,20);
		add(p2);
		
		a= new JLabel("A.");
		a.setBounds(140,310,200,40);
		add(a);
		
		uno= new JButton("");
		uno.setBounds(140,350,200,40);
		add(uno);
		
		b= new JLabel("B.");
		b.setBounds(440,310,200,40);
		add(b);
		
		dos= new JButton("");
		dos.setBounds(440,350,200,40);
		add(dos);
		
		c= new JLabel("C.");
		c.setBounds(140,400,200,40);
		add(c);
		
		tres= new JButton("");
		tres.setBounds(140,430,200,40);
		add(tres);
		
		d= new JLabel("D.");
		d.setBounds(440,400,200,40);
		add(d);
		
		cuatro= new JButton("");
		cuatro.setBounds(440,430,200,40);
		add(cuatro);
		
		ayuda= new JButton("50/50");
		ayuda.setBounds(660,150,100,100);
		add(ayuda);
		
	}
}
