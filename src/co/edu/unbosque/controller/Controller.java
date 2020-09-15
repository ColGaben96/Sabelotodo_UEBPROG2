package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.ViewBienvenida;
import co.edu.unbosque.view.View_Preguntas;
import co.edu.unbosque.view.View_empate;
import co.edu.unbosque.view.View_ganador;

public class Controller implements ActionListener{

	private View_Preguntas ven_preguntas;
	private ViewBienvenida ven_principal;
	private View_ganador ven_ganador;
	private View_empate ven_empate;
	public Controller() {
		ven_principal= new ViewBienvenida();
		ven_principal.setVisible(false);
		ven_principal.getPanelBienvenida().getBotonJugar().addActionListener(this);
		ven_preguntas= new View_Preguntas();
		ven_preguntas.setVisible(false);
		ven_ganador= new View_ganador();
		ven_ganador.setVisible(true);
		ven_empate= new View_empate();
		ven_empate.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(ven_principal.getPanelBienvenida().getBotonJugar())) {
			ven_preguntas.setVisible(true);
			ven_principal.setVisible(false);
		}
		
	}
}
