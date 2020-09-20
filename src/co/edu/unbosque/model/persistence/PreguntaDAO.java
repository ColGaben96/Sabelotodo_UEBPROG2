package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Random;

public class PreguntaDAO {
    private ArrayList<PreguntaDTO> pregunta = new ArrayList<PreguntaDTO>();
    private int numPregunta = 0;

    public void restorePregunta(String titulo, String[] pregunta, int respuesta) {
        PreguntaDTO newPregunta = new PreguntaDTO(titulo, pregunta, respuesta);
        this.pregunta.add(newPregunta);
    }

    public int lanzarNumero(int rangoPreguntas) {
        Random random = new Random(System.nanoTime());
        return random.nextInt(rangoPreguntas);
    }

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

    public boolean checkCorrecto() {
        return pregunta.get(numPregunta).esCorrecto();
    }
}
