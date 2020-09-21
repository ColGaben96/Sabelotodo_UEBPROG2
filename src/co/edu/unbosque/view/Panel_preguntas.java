package co.edu.unbosque.view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class Panel_preguntas extends JPanel implements Runnable {

	private JTextArea pregunta,p1,p2;
	private JButton uno,dos,tres,cuatro,ayuda;
	private JLabel punto1,fondo,punto2,a,b,c,d,tiempo;
	private Icon icono,ico;
	private ImageIcon imagen,im;
	public final String UNO="UNO", DOS="DOS", TRES="TRES", CUATRO="CUATRO", AYUDA="AYUDA";
	private String question;
	
	public Panel_preguntas() {
		setLayout(null);

		tiempo= new JLabel("tiempo");
		tiempo.setBounds(380,280,200,40);
		tiempo.setForeground(Color.WHITE);
		add(tiempo);
		
		pregunta= new JTextArea("Esperando a otro jugaddor...");
		pregunta.setBounds(140,80,500,200);
		pregunta.setEditable(false);
		pregunta.setLineWrap(true);
		pregunta.setWrapStyleWord(true);
		try {
			Font arial = Font.createFont(Font.TRUETYPE_FONT, new File("./sysfiles/ROCK.TTF")).deriveFont(24f);
			pregunta.setFont(arial);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		add(pregunta);
		
		punto1= new JLabel("TU");
		punto1.setBounds(200,20,100,40);
		punto1.setForeground(Color.WHITE);
		punto1.setBackground(new Color(36,38,43));
		add(punto1);
		
		p1= new JTextArea("0");
		p1.setBounds(300,30,20,20);
		p1.setEditable(false);
		add(p1);
		
		punto2= new JLabel("CONTRINCANTE");
		punto2.setBounds(400,20,100,40);
		punto2.setBackground(new Color(36,38,43));
		punto2.setForeground(Color.WHITE);
		add(punto2);
		
		p2= new JTextArea("0");
		p2.setBounds(500,30,20,20);
		p2.setEditable(false);
		add(p2);
		
		a= new JLabel("A.");
		a.setBounds(140,310,200,40);
		a.setForeground(Color.WHITE);
		//add(a);
		
		uno= new JButton("Cargando...");
		uno.setBounds(140,350,200,40);
		uno.setActionCommand(UNO);
		add(uno);
		
		b= new JLabel("B.");
		b.setBounds(440,310,200,40);
		b.setForeground(Color.WHITE);
		//add(b);
		
		dos= new JButton("Cargando...");
		dos.setBounds(440,350,200,40);
		dos.setActionCommand(DOS);
		add(dos);
		
		c= new JLabel("C.");
		c.setBounds(140,400,200,40);
		c.setForeground(Color.WHITE);
		//add(c);
		
		tres= new JButton("Cargando...");
		tres.setBounds(140,430,200,40);
		tres.setActionCommand(TRES);
		add(tres);
		
		d= new JLabel("D.");
		d.setBounds(440,400,200,40);
		d.setForeground(Color.WHITE);
		//add(d);
		
		cuatro= new JButton("Cargando...");
		cuatro.setBounds(440,430,200,40);
		cuatro.setActionCommand(CUATRO);
		add(cuatro);
		
		im= new ImageIcon(("imagenes/Presentación1.jpg"));
		ico= new ImageIcon(im.getImage().getScaledInstance(410,250,Image.SCALE_DEFAULT));
		
		ayuda= new JButton(ico);
		ayuda.setBounds(660,150,100,100);
		ayuda.setActionCommand(AYUDA);
		add(ayuda);
		
		imagen= new ImageIcon(("imagenes/x.jpg"));
		icono= new ImageIcon(imagen.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT));
		
		fondo= new JLabel(icono);
		fondo.setBounds(0,0,800,600);
		add(fondo);
	}

	public void alertQuit() {
		var ans = JOptionPane.showConfirmDialog(null, "Al salir te sacará de la partida actual y volverás al menú principal", "¿Salir?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(ans == JOptionPane.YES_OPTION) {
			MainView mv = new MainView();
			mv.goMain();
		}
	}

	public JTextArea getPregunta() {
		return pregunta;
	}

	public JTextArea getP1() {
		return p1;
	}

	public JTextArea getP2() {
		return p2;
	}

	public JButton getUno() {
		return uno;
	}

	public JButton getDos() {
		return dos;
	}

	public JButton getTres() {
		return tres;
	}

	public JButton getCuatro() {
		return cuatro;
	}

	public void setPregunta(JTextArea pregunta) {
		this.pregunta = pregunta;
	}

	public void setP1(JTextArea p1) {
		this.p1 = p1;
	}

	public void setP2(JTextArea p2) {
		this.p2 = p2;
	}

	public void setUno(JButton uno) {
		this.uno = uno;
	}

	public void setDos(JButton dos) {
		this.dos = dos;
	}

	public void setTres(JButton tres) {
		this.tres = tres;
	}

	public void setCuatro(JButton cuatro) {
		this.cuatro = cuatro;
	}

	public synchronized void paintQuestions(String question) {
		this.question=question;
		SwingUtilities.invokeLater(this);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		var questionStructure = question.split(";");
		setPregunta(new JTextArea(questionStructure[0]));
		uno.setText(questionStructure[1]);
		dos.setText(questionStructure[2]);
		tres.setText(questionStructure[3]);
		cuatro.setText(questionStructure[4]);
		validate();
		repaint();
		invalidate();
	}
}
