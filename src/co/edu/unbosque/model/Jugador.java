package co.edu.unbosque.model;

/**
 * @author Juan Pablo Araque
 * @version 1.0
 */
public class Jugador {
	private String ID;
	private int puntaje;

	/**
	 * @author Juan Pablo Araque
	 * @param ID
	 * @param puntaje
	 */
	public Jugador(String ID,int puntaje) {
		this.ID=ID;
		this.puntaje=puntaje;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
