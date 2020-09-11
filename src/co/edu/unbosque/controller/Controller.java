package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.View_Preguntas;

public class Controller implements ActionListener{

private View_Preguntas ven_preguntas;
	
	public Controller() {
		ven_preguntas= new View_Preguntas();
		ven_preguntas.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
