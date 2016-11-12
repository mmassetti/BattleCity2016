package puntajes;

import java.io.Serializable;

public class Puntaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private int puntaje;
	private String nombre;

	public int getPuntaje() {
		return puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public Puntaje(String nombre, int puntaje) {
		this.puntaje = puntaje;
		this.nombre = nombre;
	}
}
