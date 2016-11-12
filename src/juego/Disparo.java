package juego;

import java.awt.Rectangle;
import controladores.Controlador;
import visitadores.Visitor;

public abstract class Disparo extends ObjetoJuego {
	// Atributos
	protected boolean existe;
	protected int velocidadMovimiento;
	protected int direccionDisparo;
	protected Controlador miControlador;

	public Disparo(int velMov) {
		existe = true;
		velocidadMovimiento = velMov;
	}

	public Rectangle crearRectangulo() {
		switch (direccionDisparo) {
		case 0:
			return new Rectangle(miGrafico.getPos().x + 28, miGrafico.getPos().y + 14, 8, 36);
		case 1:
			return new Rectangle(miGrafico.getPos().x + 28, miGrafico.getPos().y + 14, 8, 36);
		case 2:
			return new Rectangle(miGrafico.getPos().x + 14, miGrafico.getPos().y + 28, 36, 8);
		default:
			return new Rectangle(miGrafico.getPos().x + 14, miGrafico.getPos().y + 28, 36, 8);
		}
	}

	public void cambiarDireccion(int direccion) {
		miGrafico.cambiarGrafico(direccion);
	}

	public int getDireccionDisparo() {
		return direccionDisparo;
	}

	public boolean getExiste() {
		return existe;
	}

	public void destruir() {
		existe = false;
	}

	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public abstract Visitor getVisitor();

	public abstract void setControlador(Controlador c);

	public Controlador getControlador() {
		return miControlador;
	}

	public void mover() {
		switch (direccionDisparo) {
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
		miGrafico.cambiarGrafico(direccionDisparo);
	}
}