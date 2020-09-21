package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.model.persistence.PreguntaDAO;

import java.io.IOException;

/**
 * @author Gabriel Blanco - Juan Pablo Araque
 * @version 1.0
 */
public class Sabelotodo {
	private Jugador jugador1;
	private Jugador jugador2;
    private PreguntaDAO pregunta = new PreguntaDAO();
    private Archivos archivos = new Archivos();
    private int cantPreguntas = 0;

    /**
     * @author Gabriel Blanco
     */
    public Sabelotodo() {

    }

    /**
     * @author Juan Pablo Araque
     * @param jugador1
     * @param jugador2
     */
    public Sabelotodo(Jugador jugador1,Jugador jugador2) {
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }

    /**
     * @author Gabriel Blanco
     * @throws IOException
     */
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

    /**
     * @author Gabriel Blanco
     * @param answer
     * @return
     */
    public boolean checkAnswer(int answer) {
        return pregunta.checkCorrecto(answer);
    }

    /**
     * @author Gabriel Blanco
     * @return
     */
    public String getQuestion() {
        return pregunta.readPregunta(cantPreguntas);
    }

    /**
     * @author Juan Pablo Araque
     * @return
     */
    public int getRespuestaCorrecta() {
        return pregunta.respuestaCorrecta();
    }

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
}
