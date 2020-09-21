package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

/**
 * <h1>Description:</h1><br>
 *     <p>DAO for Pregunta</p>
 * @author Gabriel Blanco - Juan Pablo Araque
 * @version 1.0
 */
public class PreguntaDAO {
    private ArrayList<PreguntaDTO> pregunta = new ArrayList<PreguntaDTO>();
    private int numPregunta = 0;

    /**
     * @author Gabriel Blanco
     * @param titulo
     * @param pregunta
     * @param respuesta
     */
    public void restorePregunta(String titulo, String[] pregunta, int respuesta) {
        PreguntaDTO newPregunta = new PreguntaDTO(titulo, pregunta, respuesta);
        this.pregunta.add(newPregunta);
    }

    /**
     * @author Gabriel Blanco
     * @param rangoPreguntas
     * @return
     */
    public int lanzarNumero(int rangoPreguntas) {
        Random random = new Random(System.nanoTime());
        return random.nextInt(rangoPreguntas);
    }

    /**
     * @author Gabriel Blanco
     * @param rangoPreguntas
     * @return
     */
    public String readPregunta(int rangoPreguntas) {
        numPregunta = lanzarNumero(rangoPreguntas);
        var titulo = this.pregunta.get(numPregunta).getTitulo();
        var preguntas = this.pregunta.get(numPregunta).getPregunta();
        var correcta = this.pregunta.get(numPregunta).getRespuesta();
        var preguntasComma = titulo+";";
        for (String s : preguntas) {
            if (s != null) {
                preguntasComma += s + ";";
            }
        }
        preguntasComma += correcta;
        return preguntasComma;
    }

    /**
     * @author Gabriel Blanco
     * @param answer
     * @return
     */
    public boolean checkCorrecto(int answer) {
        if(answer == pregunta.get(numPregunta).getRespuesta()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author Juan Pablo Araque
     * @return
     */
    public int respuestaCorrecta() {
        return pregunta.get(numPregunta).getRespuesta();
    }
}
