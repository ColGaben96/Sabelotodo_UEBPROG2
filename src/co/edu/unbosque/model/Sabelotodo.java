package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.model.persistence.PreguntaDAO;

import java.io.IOException;

public class Sabelotodo {
	private Jugador jugador1;
	private Jugador jugador2;
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
    private PreguntaDAO pregunta = new PreguntaDAO();
    private Archivos archivos = new Archivos();
    private int cantPreguntas = 0;

    public Sabelotodo() {

    }

    public Sabelotodo(Jugador jugador1,Jugador jugador2) {
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }

    public void startServer() throws IOException {
        var arreglo = archivos.read().split("\n");
        cantPreguntas = arreglo.length;
        for (String s : arreglo) {
            var pregunta = s.split(";");
            var titulo = pregunta[0];
            String[] preguntas = new String[pregunta.length];
            for (int k = 1; k < pregunta.length-1; k++) {
                preguntas[k] = pregunta[k];
            }
            int respuesta = Integer.parseInt(pregunta[5]);
            this.pregunta.restorePregunta(titulo, preguntas, respuesta);
        }
    }

    public void sendAnswer() {

    }
}
