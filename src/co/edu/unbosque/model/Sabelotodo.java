package co.edu.unbosque.model;

public class Sabelotodo {
	Jugador jugador1;
	Jugador jugador2;
	public Sabelotodo(Jugador jugador1,Jugador jugador2) {
		this.jugador1=jugador1;
		this.jugador2=jugador2;
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
