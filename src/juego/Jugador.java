package juego;

import grafica.JugadorGrafico;
import niveles.Nivel;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import TDALista.*;

public class Jugador extends Tanque {

	/* Crear clase Nivel abstracta y extender con los cuatro niveles */

	// Atributos
	protected int vidas;
	protected int cantPuntos;
	protected Nivel nivel;
	protected TerminadorJuego miTerminador;

	// Constructor
	public Jugador(int x, int y, TerminadorJuego terminador) {
		super(1, 10, 10, 10);
		vidas = 0;
		cantPuntos = 0;
		miGrafico = new JugadorGrafico(x, y);
		direccionActual = 0;
		miRectangulo= new Rectangle(miGrafico.getPos().x,miGrafico.getPos().y,55,55);
		miTerminador = terminador;
		// nivel = new Nivel1() ??;
		// nivel= n;
	}

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
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

	public void setDireccionActual(int n) {
		direccionActual = n;
	}
	
	public Disparo disparar(){
		return new DisparoJugador(miGrafico.getPos().x, miGrafico.getPos().y, direccionActual);
	}
	

	// Metodos
	public void morir() {
		miTerminador.terminarJuego();
	}
}
