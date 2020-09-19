package co.edu.unbosque.view;

import javax.swing.JFrame;

public class View_empate extends JFrame{

	private Panel_empate empate;
	public View_empate() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		getContentPane().setLayout(null);
		
		empate= new Panel_empate();
		empate.setBounds(0,0,400,300);
		add(empate);
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
