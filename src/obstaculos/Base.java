package obstaculos;

import grafica.BaseGrafica;
import juego.TerminadorJuego;
import visitadores.VisitadorConcretoBase;
import visitadores.VisitorObstaculos;

public class Base extends Obstaculo {

	protected VisitadorConcretoBase miVisitador;

	public Base(int x, int y, TerminadorJuego t) {
		resistencia = 1;
		miVisitador = new VisitadorConcretoBase(this, t);
		atraviesaBala = false;
		miGrafico = new BaseGrafica(x, y);
	}

	public VisitorObstaculos getVisitor() {
		return miVisitador;
	}

	public int recibirDisparo() {
		resistencia--;
		return resistencia;
	}
}
