package co.edu.unbosque.model;

public class Jugador {
	private String ID;
	private int puntaje;
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
