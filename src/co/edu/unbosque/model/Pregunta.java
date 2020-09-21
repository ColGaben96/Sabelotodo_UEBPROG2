package co.edu.unbosque.model;

public interface Pregunta {
    public String getTitulo();
    public String[] getPregunta();
    public int getRespuesta();
    public boolean esCorrecto();
}
