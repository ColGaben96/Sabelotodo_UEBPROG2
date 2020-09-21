package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Pregunta;

/**
 * @author Gabriel Blanco
 * @version 1.0
 */
public class PreguntaDTO implements Pregunta {

    private String titulo;
    private String[] pregunta;
    private int respuesta;

    /**
     * @author Gabriel Blanco
     * @param titulo
     * @param pregunta
     * @param respuesta
     */
    public PreguntaDTO(String titulo, String[] pregunta, int respuesta) {
        this.titulo = titulo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String[] getPregunta() {
        return pregunta;
    }

    @Override
    public int getRespuesta() {
        return respuesta;
    }

    @Override
    public boolean esCorrecto() {
        if(pregunta[5].equals(String.valueOf(respuesta))) {
            return true;
        } else {
            return false;
        }
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPregunta(String[] pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}
