package co.edu.unbosque.model;

/**
 * <h1>Description:</h1><br>
 *     <p>This interface is the complete structure of it.</p>
 * @author Gabriel Blanco
 * @version 1.0
 */
public interface Pregunta {
    public String getTitulo();
    public String[] getPregunta();
    public int getRespuesta();
    public boolean esCorrecto();
}
