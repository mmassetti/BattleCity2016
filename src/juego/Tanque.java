package juego;

import java.awt.Rectangle;
import TDALista.PositionList;

public abstract class Tanque extends ObjetoJuego {

	// Atributos
	protected int resistenciaGolpes;
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	protected int direccionActual;
	protected int disparoSimultaneo;
	protected PositionList<Disparo> disparosActuales;

	// Getters

	public int getDireccionActual() {
		return direccionActual;
	}

	public PositionList<Disparo> getDisparosActuales() {
		return disparosActuales;
	}

	// Setters

	public void setDireccionActual(int n) {
		direccionActual = n;
	}

	public abstract void recibirDisparo();

	public abstract void disparar();

	// Metodos
	public void mover() {
		switch (direccionActual) {
		case 0:// Arriba
			miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y - velocidadMovimiento);
			break;
		case 1: // Abajo
			miGrafico.getPos().setLocation(miGrafico.getPos().x, miGrafico.getPos().y + velocidadMovimiento);
			break;
		case 2: // Izquierda
			miGrafico.getPos().setLocation(miGrafico.getPos().x - velocidadMovimiento, miGrafico.getPos().y);
			break;
		case 3: // Derecha
			miGrafico.getPos().setLocation(miGrafico.getPos().x + velocidadMovimiento, miGrafico.getPos().y);
			break;
		}
	}

	public Rectangle posicionAMover() {
		int posX = 0, posY = 0;
		switch (direccionActual) {
		case 0: { // Arriba
			posX = miGrafico.getPos().x;
			posY = miGrafico.getPos().y - velocidadMovimiento;
			break;
		}
		case 1: { // Abajo
			posX = miGrafico.getPos().x;
			posY = miGrafico.getPos().y + velocidadMovimiento;
			break;
		}
		case 2: { // Izquierda
			posX = miGrafico.getPos().x - velocidadMovimiento;
			posY = miGrafico.getPos().y;
			break;
		}
		case 3: { // Derecha
			posX = miGrafico.getPos().x + velocidadMovimiento;
			posY = miGrafico.getPos().y;
			break;
		}
		}
		miRectangulo.setBounds(posX, posY, 57, 57);
		return miRectangulo;
	}

	/* Jugadpr y Enemigo redefinen el metodo porque no tiene el mismo efecto */
	public abstract void morir();
}
