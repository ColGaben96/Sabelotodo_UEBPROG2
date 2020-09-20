package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.model.persistence.PreguntaDAO;

import java.io.IOException;

public class Sabelotodo {
    private PreguntaDAO pregunta = new PreguntaDAO();
    private Archivos archivos = new Archivos();
    private int cantPreguntas = 0;

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
        System.out.println(pregunta.readPregunta(cantPreguntas));
    }
}
