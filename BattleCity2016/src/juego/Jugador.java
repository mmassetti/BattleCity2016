package juego;

import grafica.JugadorGrafico;

public class Jugador extends Tanque {

	/* Crear clase Nivel abstracta y extender con los cuatro niveles */

	// Atributos
	protected int vidas;
	protected int cantPuntos;
	protected Nivel nivel;

	// Constructor

	public Jugador(int x, int y, int res, int vM, int vD, int dS,Nivel n) {
		super(res, vM, vD, dS);
		vidas = 0;
		cantPuntos = 0;
		//nivel = new Nivel1() ??;
		miGrafico= new JugadorGrafico(x,y);
		nivel= n;
	}

	// Getters

	public int getVidas() {
		return vidas;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public int getCantPuntos() {
		return cantPuntos;
	}

	// Setters

	public void aumentarVida() {
		this.vidas++;
	}

	public void setCantPuntos(int cantPuntos) {
		this.cantPuntos = cantPuntos;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	// Metodos

	public void morir() {

	}

}